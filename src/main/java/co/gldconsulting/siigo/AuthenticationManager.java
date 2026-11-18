package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.Authentication;
import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.resource.AuthenticationResource;
import co.gldconsulting.siigo.service.TokenProvider;
import java.time.Clock;
import java.time.Instant;
import java.util.Objects;

/** Shared in-memory session; manual tokens and external providers bypass automatic authentication. */
final class AuthenticationManager implements TokenProvider {
    private final AuthenticationResource resource;
    private final Clock clock;
    private AuthenticationCredentials credentials;
    private String accessToken;
    private Instant renewAt = Instant.MIN;
    private TokenProvider external;
    AuthenticationManager(AuthenticationResource resource, Clock clock, AuthenticationCredentials credentials, String token) {
        this.resource = resource; this.clock = clock;
        if (credentials != null) this.credentials = copy(credentials);
        if (token != null) setAccessToken(token);
    }
    synchronized Authentication authenticate(AuthenticationCredentials value) {
        AuthenticationCredentials next = copy(Objects.requireNonNull(value, "credentials"));
        Authentication result = resource.authenticate(next);
        if (result == null || result.getAccessToken() == null || result.getAccessToken().isBlank()) throw new IllegalStateException("Authentication response has no access_token");
        long ttl = result.getExpiresIn() == null ? 86400 : result.getExpiresIn();
        if (ttl <= 0) throw new IllegalStateException("Authentication response has invalid expires_in");
        credentials = next; accessToken = result.getAccessToken();
        renewAt = clock.instant().plusSeconds(ttl - Math.min(30, ttl / 10));
        return result;
    }
    synchronized void setAccessToken(String token) {
        String checked = Preconditions.text(token, "accessToken");
        if (checked.startsWith("Bearer ")) throw new IllegalArgumentException("Provide the token without the Bearer prefix");
        external = () -> checked;
    }
    synchronized void setTokenProvider(TokenProvider provider) { external = Objects.requireNonNull(provider, "tokenProvider"); }
    synchronized void useAutomaticAuthentication() {
        if (credentials == null) throw new IllegalStateException("Configure credentials or authenticate before enabling automatic authentication");
        external = null; accessToken = null; renewAt = Instant.MIN;
    }
    @Override public synchronized String getAccessToken() {
        if (external != null) return external.getAccessToken();
        if (accessToken == null || !clock.instant().isBefore(renewAt)) {
            if (credentials == null) throw new IllegalStateException("Configure credentials, a token, or a TokenProvider before calling Siigo services");
            authenticate(credentials);
        }
        return accessToken;
    }
    @Override public synchronized boolean refreshAfterUnauthorized(String rejectedToken) {
        if (external != null) return external.refreshAfterUnauthorized(rejectedToken);
        if (Objects.equals(accessToken, rejectedToken)) { accessToken = null; renewAt = Instant.MIN; }
        return credentials != null;
    }
    private static AuthenticationCredentials copy(AuthenticationCredentials value) {
        return new AuthenticationCredentials().setUsername(Preconditions.text(value.getUsername(), "username"))
                .setAccessKey(Preconditions.text(value.getAccessKey(), "accessKey"));
    }
}
