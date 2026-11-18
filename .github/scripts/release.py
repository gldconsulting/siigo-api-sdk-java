#!/usr/bin/env python3
"""Release the current Maven version, then advance the development version."""
import argparse
import json
import os
from pathlib import Path
import re
import subprocess
import urllib.error
import urllib.request
import xml.etree.ElementTree as ET

FINGERPRINT = '434B3A027E446955BD0F90E692F718364BF0676A'
STATE = '.github/release-state.json'
NS = {'m': 'http://maven.apache.org/POM/4.0.0'}


class ReleaseError(RuntimeError):
    pass


def versions(current, major=False, minor=False):
    if major and minor:
        raise ReleaseError('releaseMajorVersion and releaseMinorVersion cannot both be true.')
    match = re.fullmatch(r'(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)-SNAPSHOT', current)
    if not match:
        raise ReleaseError('A new release must start from an X.Y.Z-SNAPSHOT project version.')
    a, b, c = map(int, match.groups())
    following = (a + 1, 0, 0) if major else (a, b + 1, 0) if minor else (a, b, c + 1)
    return current.removesuffix('-SNAPSHOT'), '.'.join(map(str, following)) + '-SNAPSHOT'


def git(repo, *args):
    return subprocess.check_output(['git', *args], cwd=repo, text=True, stderr=subprocess.PIPE).strip()


def coordinates(text):
    root = ET.fromstring(text)
    return tuple(root.find('m:' + field, NS).text for field in ('groupId', 'artifactId', 'version'))


def change_pom(repo, version, tag):
    path = repo / 'pom.xml'
    text = path.read_text()
    current = coordinates(text)[2]
    first_version = re.search(r'<version>([^<]+)</version>', text)
    if first_version is None or first_version.group(1) != current:
        raise ReleaseError('Unsupported POM layout; refusing to edit a dependency or parent version.')
    text = text[:first_version.start(1)] + version + text[first_version.end(1):]
    text, count = re.subn(r'(<scm>.*?<tag>)[^<]*(</tag>)', lambda m: m[1] + tag + m[2], text, flags=re.S)
    if count != 1:
        raise ReleaseError('Expected exactly one scm/tag in pom.xml.')
    path.write_text(text)


def save_state(repo, state):
    path = repo / STATE
    path.parent.mkdir(exist_ok=True)
    path.write_text(json.dumps(state, indent=2, sort_keys=True) + '\n')


def commit(repo, message):
    git(repo, 'add', '--', 'pom.xml', STATE)
    git(repo, '-c', 'user.name=github-actions[bot]', '-c',
        'user.email=41898282+github-actions[bot]@users.noreply.github.com', 'commit', '-m', message)


def central_has_release(group, artifact, version):
    url = f'https://repo.maven.apache.org/maven2/{group.replace(".", "/")}/{artifact}/{version}/{artifact}-{version}.pom'
    try:
        with urllib.request.urlopen(url, timeout=30) as response:
            text = response.read(1_000_000).decode()
    except urllib.error.HTTPError as ex:
        if ex.code == 404:
            return False
        raise ReleaseError(f'Central lookup failed with HTTP {ex.code}; publication was not attempted.') from None
    except (OSError, ValueError) as ex:
        raise ReleaseError('Could not confirm the Central state; publication was not attempted.') from ex
    if coordinates(text) != (group, artifact, version):
        raise ReleaseError('Central returned a POM with unexpected coordinates.')
    return True


def publish_maven(repo):
    subprocess.run(['./mvnw', '--batch-mode', '--no-transfer-progress', '-Prelease',
                    '-Dgpg.keyname=' + FINGERPRINT, '-Dgpg.bestPractices=true',
                    '-Dcentral.autoPublish=true', '-Dcentral.waitUntil=published',
                    'clean', 'deploy'], cwd=repo, check=True)


def ensure_github_release(repo, tag, repository):
    # An API 404 is the only condition that permits creating a new release.
    result = subprocess.run(['gh', 'api', f'repos/{repository}/releases/tags/{tag}'],
                            cwd=repo, capture_output=True, text=True)
    if result.returncode == 0:
        existing = json.loads(result.stdout)
        if existing.get('draft') or existing.get('prerelease'):
            raise ReleaseError('An existing draft/prerelease needs review before completing this release.')
        return
    if 'HTTP 404' not in result.stderr:
        raise ReleaseError('Could not check the GitHub Release; refusing to assume it is absent.')
    subprocess.run(['gh', 'release', 'create', tag, '--repo', repository, '--verify-tag',
                    '--generate-notes', '--title', tag], cwd=repo, check=True)


def execute(repo, major=False, minor=False, dry_run=False, env=None,
            is_published=central_has_release, publish=publish_maven, github_release=ensure_github_release):
    repo = Path(repo)
    env = os.environ if env is None else env
    if env.get('GITHUB_REF') != 'refs/heads/main':
        raise ReleaseError('Run the release workflow from main.')
    if major and minor:
        raise ReleaseError('releaseMajorVersion and releaseMinorVersion cannot both be true.')
    run_id = env.get('GITHUB_RUN_ID')
    repository = env.get('GITHUB_REPOSITORY')
    if not run_id or not repository:
        raise ReleaseError('This command requires the GitHub Actions run and repository context.')
    if git(repo, 'status', '--porcelain'):
        raise ReleaseError('The release checkout must be clean.')
    if git(repo, 'branch', '--show-current') != 'main':
        raise ReleaseError('The checked-out branch must be main.')
    git(repo, 'fetch', 'origin', 'main', '--tags')
    git(repo, 'merge', '--ff-only', 'origin/main')
    group, artifact, current = coordinates((repo / 'pom.xml').read_text())
    state_path = repo / STATE
    state = json.loads(state_path.read_text()) if state_path.exists() else None
    if state and state.get('status') == 'completed' and run_id in (state.get('runId'), state.get('completedByRunId')):
        return dict(state, noOp=True, dryRun=dry_run)
    if state and state.get('status') == 'prepared':
        release, development, tag = state['releaseVersion'], state['nextDevelopmentVersion'], state['tag']
        if current != release or tag != 'v' + release:
            raise ReleaseError('Pending release state does not match pom.xml.')
        tagged_state = json.loads(git(repo, 'show', f'{tag}:{STATE}'))
        if tagged_state != state or coordinates(git(repo, 'show', f'{tag}:pom.xml')) != (group, artifact, release):
            raise ReleaseError('Pending release tag does not match the recorded source and version.')
        resume = True
    else:
        if state and state.get('status') != 'completed':
            raise ReleaseError('Unknown release state; refusing to guess.')
        release, development = versions(current, major, minor)
        tag = 'v' + release
        if subprocess.run(['git', 'rev-parse', '--verify', '--quiet', 'refs/tags/' + tag], cwd=repo,
                          stdout=subprocess.DEVNULL).returncode == 0:
            raise ReleaseError('The release tag already exists without a matching pending state.')
        state = {'schemaVersion': 1, 'status': 'prepared', 'runId': run_id,
                 'releaseVersion': release, 'nextDevelopmentVersion': development,
                 'tag': tag, 'sourceSha': git(repo, 'rev-parse', 'HEAD')}
        resume = False
    plan = dict(state, resumed=resume, dryRun=dry_run, noOp=False)
    if dry_run:
        return plan
    for name in ('GH_TOKEN', 'MAVEN_CENTRAL_USERNAME', 'MAVEN_CENTRAL_PASSWORD', 'MAVEN_GPG_PASSPHRASE'):
        if not env.get(name):
            raise ReleaseError(f'{name} is missing or empty; no release was prepared.')
    if not resume:
        if is_published(group, artifact, release):
            raise ReleaseError('This version is already on Central without a matching pending release state.')
        change_pom(repo, release, tag)
        save_state(repo, state)
        commit(repo, f'Release {release}')
        git(repo, '-c', 'user.name=github-actions[bot]', '-c',
            'user.email=41898282+github-actions[bot]@users.noreply.github.com', 'tag', '-a', tag, '-m', f'Release {release}')
        # Neither the branch nor the tag moves if main advanced concurrently.
        git(repo, 'push', '--atomic', 'origin', 'HEAD:refs/heads/main', 'refs/tags/' + tag)
    git(repo, 'switch', '--detach', tag)
    if not is_published(group, artifact, release):
        publish(repo)  # Central's plugin waits until published, not merely uploaded/validated.
    github_release(repo, tag, repository)
    git(repo, 'switch', 'main')
    git(repo, 'fetch', 'origin', 'main')
    git(repo, 'merge', '--ff-only', 'origin/main')
    latest = json.loads((repo / STATE).read_text())
    if latest != state or coordinates((repo / 'pom.xml').read_text()) != (group, artifact, release):
        raise ReleaseError('The pending version/state changed on main; publication is complete but the next version needs review.')
    change_pom(repo, development, 'HEAD')
    completed = dict(state, status='completed', completedByRunId=run_id)
    save_state(repo, completed)
    commit(repo, f'Prepare next development version {development}')
    git(repo, 'push', 'origin', 'HEAD:refs/heads/main')
    return dict(completed, resumed=resume, dryRun=False, noOp=False)


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument('--major', action='store_true')
    parser.add_argument('--minor', action='store_true')
    parser.add_argument('--dry-run', action='store_true')
    args = parser.parse_args()
    try:
        result = execute(Path.cwd(), args.major, args.minor, args.dry_run)
    except (ReleaseError, subprocess.CalledProcessError, OSError, ValueError, KeyError) as ex:
        raise SystemExit(f'Release stopped: {ex}') from None
    print(json.dumps(result, indent=2))
    summary = os.environ.get('GITHUB_STEP_SUMMARY')
    if summary:
        with open(summary, 'a') as output:
            output.write(f'### Release plan/result\n\nRelease: `{result["releaseVersion"]}`\n\nNext development version: `{result["nextDevelopmentVersion"]}`\n\n')
            output.write(f'Dry run: `{result["dryRun"]}`; already completed run: `{result["noOp"]}`.\n')


if __name__ == '__main__':
    main()
