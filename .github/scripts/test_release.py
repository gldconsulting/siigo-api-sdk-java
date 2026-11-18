import json
from pathlib import Path
import subprocess
import tempfile
import unittest

from release import ReleaseError, STATE, change_pom, coordinates, execute, git, versions

POM = '''<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <groupId>co.gldconsulting</groupId><artifactId>siigo-api-sdk</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <scm><tag>HEAD</tag></scm>
  <dependencies><dependency><version>9.9.9</version></dependency></dependencies>
</project>'''


class VersionTests(unittest.TestCase):
    def test_patch_major_and_minor_describe_the_version_after_the_release(self):
        self.assertEqual(('1.0.0', '1.0.1-SNAPSHOT'), versions('1.0.0-SNAPSHOT'))
        self.assertEqual(('1.2.3', '2.0.0-SNAPSHOT'), versions('1.2.3-SNAPSHOT', major=True))
        self.assertEqual(('1.2.3', '1.3.0-SNAPSHOT'), versions('1.2.3-SNAPSHOT', minor=True))

    def test_invalid_or_ambiguous_versions_are_rejected(self):
        for value in ('1.0.0', '01.0.0-SNAPSHOT', '1.0-SNAPSHOT', '1.0.0-RC1', '${revision}', 'x.y.z-SNAPSHOT'):
            with self.subTest(value=value), self.assertRaises(ReleaseError):
                versions(value)
        with self.assertRaises(ReleaseError):
            versions('1.0.0-SNAPSHOT', True, True)


class LifecycleTests(unittest.TestCase):
    def setUp(self):
        self.temp = tempfile.TemporaryDirectory(prefix='gld-release-test-')
        self.addCleanup(self.temp.cleanup)
        self.root = Path(self.temp.name)
        self.origin = self.root / 'origin.git'
        self.repo = self.root / 'checkout'
        subprocess.run(['git', 'init', '--bare', '--initial-branch=main', str(self.origin)], check=True, capture_output=True)
        subprocess.run(['git', 'clone', str(self.origin), str(self.repo)], check=True, capture_output=True)
        git(self.repo, 'config', 'user.name', 'SDK release test')
        git(self.repo, 'config', 'user.email', 'fixture@example.invalid')
        git(self.repo, 'config', 'commit.gpgsign', 'false')
        git(self.repo, 'config', 'tag.gpgsign', 'false')
        (self.repo / 'pom.xml').write_text(POM)
        git(self.repo, 'add', 'pom.xml')
        git(self.repo, 'commit', '-m', 'Fixture')
        git(self.repo, 'push', '-u', 'origin', 'main')
        self.initial = git(self.repo, 'rev-parse', 'HEAD')
        self.env = {'GITHUB_REF': 'refs/heads/main', 'GITHUB_RUN_ID': '100',
                    'GITHUB_REPOSITORY': 'fixture/sdk', 'GH_TOKEN': 'synthetic-token',
                    'MAVEN_CENTRAL_USERNAME': 'synthetic-user', 'MAVEN_CENTRAL_PASSWORD': 'synthetic-token',
                    'MAVEN_GPG_PASSPHRASE': 'synthetic-passphrase'}
        self.published = set()
        self.events = []

    def has_release(self, group, artifact, version):
        return version in self.published

    def publish(self, repo):
        version = coordinates((repo / 'pom.xml').read_text())[2]
        self.assertEqual('', git(repo, 'branch', '--show-current'))
        self.assertEqual(git(repo, 'rev-parse', 'HEAD'), git(repo, 'rev-parse', 'v' + version + '^{commit}'))
        self.published.add(version)
        self.events.append(('published', version))

    def github_release(self, repo, tag, repository):
        self.assertIn(tag.removeprefix('v'), self.published)
        self.assertEqual('fixture/sdk', repository)
        self.events.append(('github-release', tag))

    def run_release(self, **kwargs):
        defaults = dict(env=self.env, is_published=self.has_release, publish=self.publish, github_release=self.github_release)
        defaults.update(kwargs)
        return execute(self.repo, **defaults)

    def assert_completed(self, development='1.0.1-SNAPSHOT'):
        self.assertEqual(development, coordinates((self.repo / 'pom.xml').read_text())[2])
        self.assertIn('<tag>HEAD</tag>', (self.repo / 'pom.xml').read_text())
        self.assertIn('<version>9.9.9</version>', (self.repo / 'pom.xml').read_text())
        tagged = git(self.repo, 'show', 'v1.0.0:pom.xml')
        self.assertEqual('1.0.0', coordinates(tagged)[2])
        self.assertIn('<tag>v1.0.0</tag>', tagged)
        state = json.loads((self.repo / STATE).read_text())
        self.assertEqual('completed', state['status'])
        self.assertEqual(git(self.repo, 'rev-parse', 'HEAD'), git(self.repo, 'rev-parse', 'origin/main'))

    def test_full_release_commits_tag_and_next_version_after_publication(self):
        self.run_release()
        self.assert_completed()
        self.assertEqual([('published', '1.0.0'), ('github-release', 'v1.0.0')], self.events)

    def test_major_and_minor_reset_lower_components(self):
        self.run_release(major=True)
        self.assert_completed('2.0.0-SNAPSHOT')

    def test_minor(self):
        self.run_release(minor=True)
        self.assert_completed('1.1.0-SNAPSHOT')

    def test_dry_run_has_no_version_commit_tag_or_publication_side_effect(self):
        result = self.run_release(dry_run=True, minor=True)
        self.assertEqual('1.1.0-SNAPSHOT', result['nextDevelopmentVersion'])
        self.assertEqual(self.initial, git(self.repo, 'rev-parse', 'HEAD'))
        self.assertFalse((self.repo / STATE).exists())
        self.assertEqual('', git(self.repo, 'tag', '--list'))
        self.assertEqual([], self.events)

    def test_mutually_exclusive_flags_stop_before_remote_changes(self):
        with self.assertRaises(ReleaseError):
            self.run_release(major=True, minor=True)
        self.assertEqual(self.initial, git(self.repo, 'rev-parse', 'HEAD'))

    def test_rerun_of_completed_run_is_idempotent(self):
        self.run_release()
        completed = git(self.repo, 'rev-parse', 'HEAD')
        result = self.run_release()
        self.assertTrue(result['noOp'])
        self.assertEqual(completed, git(self.repo, 'rev-parse', 'HEAD'))
        self.assertEqual(2, len(self.events))

    def test_a_new_run_releases_the_next_patch(self):
        self.run_release()
        self.env['GITHUB_RUN_ID'] = '101'
        self.run_release()
        self.assertEqual('1.0.2-SNAPSHOT', coordinates((self.repo / 'pom.xml').read_text())[2])
        self.assertEqual({'1.0.0', '1.0.1'}, self.published)

    def test_failed_publication_keeps_pending_source_and_retries_original_increment(self):
        def fail(repo):
            raise ReleaseError('Simulated publisher failure')
        with self.assertRaises(ReleaseError):
            self.run_release(publish=fail)
        self.assertEqual('prepared', json.loads((self.repo / STATE).read_text())['status'])
        self.assertEqual('1.0.0', coordinates((self.repo / 'pom.xml').read_text())[2])
        git(self.repo, 'switch', 'main')  # A fresh CI attempt checks out main.
        self.run_release(minor=True)
        self.assert_completed()  # The increment recorded before the failure is retained.

    def test_published_release_resumes_without_redeploying_after_github_failure(self):
        def fail(repo, tag, repository):
            raise ReleaseError('Simulated GitHub outage')
        with self.assertRaises(ReleaseError):
            self.run_release(github_release=fail)
        git(self.repo, 'switch', 'main')
        self.env['GITHUB_RUN_ID'] = '101'
        self.run_release()
        self.assert_completed()
        self.assertEqual(1, sum(event[0] == 'published' for event in self.events))
        self.assertTrue(self.run_release()['noOp'])

    def test_existing_version_or_unrelated_tag_does_not_get_republished(self):
        self.published.add('1.0.0')
        with self.assertRaises(ReleaseError):
            self.run_release()
        self.assertEqual(self.initial, git(self.repo, 'rev-parse', 'HEAD'))
        self.published.clear()
        git(self.repo, 'tag', 'v1.0.0')
        with self.assertRaises(ReleaseError):
            self.run_release()

    def test_missing_credentials_and_wrong_branch_fail_before_preparation(self):
        self.env.pop('MAVEN_CENTRAL_PASSWORD')
        with self.assertRaises(ReleaseError):
            self.run_release()
        self.assertFalse((self.repo / STATE).exists())
        self.env['GITHUB_REF'] = 'refs/heads/other'
        with self.assertRaises(ReleaseError):
            self.run_release(dry_run=True)

    def test_dirty_source_is_not_committed_or_released(self):
        (self.repo / 'unreviewed.txt').write_text('Unrelated change')
        with self.assertRaises(ReleaseError):
            self.run_release()
        self.assertEqual(self.initial, git(self.repo, 'rev-parse', 'HEAD'))


if __name__ == '__main__':
    unittest.main()
