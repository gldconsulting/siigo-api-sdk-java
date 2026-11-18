package co.gldconsulting.siigo;


import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.model.JournalRequest;
import co.gldconsulting.siigo.service.SiigoApiException;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthenticationIT {
    private static AuthenticationCredentials credentials() { return new AuthenticationCredentials().setUsername("integration@example.test").setAccessKey("synthetic-key"); }
    private static SiigoApi.Builder builder(MockSiigoServer server) {
        return SiigoApi.builder().withCommunicationConfig(CommunicationConfig.builder().setApiUrl(server.url()).setPartnerId("test-partner"));
    }
    private static String auth(String token, int ttl) { return "{\"access_token\":\"" + token + "\",\"expires_in\":" + ttl + ",\"token_type\":\"Bearer\"}"; }
    @Test void automaticSessionAuthenticatesOnceAndInjectsSharedHeaders() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(200, auth("token-one", 86400)); server.enqueue(200, "[]"); server.enqueue(200, "[]");
            try (SiigoApi api = builder(server).setCredentials(credentials()).build()) {
                api.getCatalogService().getTaxes(); api.getCatalogService().getWarehouses();
            }
            assertEquals(3, server.requests.size());
            assertEquals("/auth", server.requests.getFirst().path());
            assertNull(server.requests.getFirst().header("Authorization"));
            assertTrue(server.requests.getFirst().body().contains("\"access_key\":\"synthetic-key\""));
            server.requests.forEach(r -> assertEquals("test-partner", r.header("Partner-Id")));
            assertEquals("Bearer token-one", server.requests.get(1).header("Authorization"));
            assertEquals("Bearer token-one", server.requests.get(2).header("Authorization"));
        }
    }
    @Test void expiresInIsUsedToRefreshBeforeExpiration() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            MutableClock clock = new MutableClock();
            server.enqueue(200, auth("one", 100)); server.enqueue(200, "[]");
            server.enqueue(200, auth("two", 100)); server.enqueue(200, "[]");
            try (SiigoApi api = SiigoApi.builder().withCommunicationConfig(CommunicationConfig.builder().setApiUrl(server.url()).setPartnerId("test-partner").setClock(clock)).setCredentials(credentials()).build()) {
                api.getCatalogService().getTaxes(); clock.advance(95); api.getCatalogService().getTaxes();
            }
            assertEquals(4, server.requests.size());
            assertEquals("Bearer one", server.requests.get(1).header("Authorization"));
            assertEquals("Bearer two", server.requests.get(3).header("Authorization"));
        }
    }
    @Test void unauthorizedReadRenewsAndRetriesOnlyOnce() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(200, auth("old", 86400)); server.enqueue(401, "{}"); server.enqueue(200, auth("new", 86400)); server.enqueue(401, "{}");
            try (SiigoApi api = builder(server).setCredentials(credentials()).build()) {
                assertEquals(401, assertThrows(SiigoApiException.class, () -> api.getCatalogService().getTaxes()).getStatusCode());
            }
            assertEquals(4, server.requests.size());
            assertEquals("Bearer old", server.requests.get(1).header("Authorization"));
            assertEquals("Bearer new", server.requests.get(3).header("Authorization"));
        }
    }
    @Test void mutationIsNotReplayedAfterUnauthorized() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(200, auth("one", 86400)); server.enqueue(401, "{}");
            try (SiigoApi api = builder(server).setCredentials(credentials()).build()) {
                assertEquals(401, assertThrows(SiigoApiException.class, () -> api.getJournalService().createJournal(new JournalRequest(), "uniqueDocument1")).getStatusCode());
            }
            assertEquals(2, server.requests.size()); assertEquals("POST", server.requests.getLast().method());
        }
    }
    @Test void applicationProviderChangesTokensWithoutAuthenticationCalls() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            AtomicReference<String> token = new AtomicReference<>("external-one");
            server.enqueue(200, "[]"); server.enqueue(200, "[]"); server.enqueue(401, "{}");
            try (SiigoApi api = builder(server).setCredentials(credentials()).setTokenProvider(token::get).build()) {
                api.getCatalogService().getTaxes(); token.set("external-two"); api.getCatalogService().getTaxes();
                assertThrows(SiigoApiException.class, () -> api.getCatalogService().getTaxes());
            }
            assertEquals(3, server.requests.size());
            assertTrue(server.requests.stream().noneMatch(r -> r.path().equals("/auth")));
            assertEquals("Bearer external-one", server.requests.getFirst().header("Authorization"));
            assertEquals("Bearer external-two", server.requests.get(1).header("Authorization"));
        }
    }
    @Test void manualTokenCanOverrideAutomaticLifecycleAndAutomaticModeCanResume() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(200, auth("automatic-one", 86400)); server.enqueue(200, "[]");
            server.enqueue(200, "[]"); server.enqueue(200, "[]"); server.enqueue(200, auth("automatic-two", 86400)); server.enqueue(200, "[]");
            try (SiigoApi api = builder(server).setCredentials(credentials()).build()) {
                api.getCatalogService().getTaxes(); api.setAccessToken("manual-one"); api.getCatalogService().getTaxes();
                api.setAccessToken("manual-two"); api.getCatalogService().getTaxes();
                api.useAutomaticAuthentication(); api.getCatalogService().getTaxes();
            }
            assertEquals(6, server.requests.size());
            assertEquals("Bearer manual-one", server.requests.get(2).header("Authorization"));
            assertEquals("Bearer manual-two", server.requests.get(3).header("Authorization"));
            assertEquals("Bearer automatic-two", server.requests.getLast().header("Authorization"));
        }
    }
    @Test void manualUnauthorizedTokenIsNotAutomaticallyRenewed() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(401, "{}");
            try (SiigoApi api = builder(server).setAccessToken("manual").build()) {
                assertEquals(401, assertThrows(SiigoApiException.class, () -> api.getCatalogService().getTaxes()).getStatusCode());
            }
            assertEquals(1, server.requests.size());
        }
    }
    @Test void externalProviderCanUseAuthenticationServiceWithoutLosingLifecycleOwnership() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            AtomicReference<SiigoApi> owner = new AtomicReference<>();
            AtomicReference<String> token = new AtomicReference<>();
            server.enqueue(200, auth("fetched-by-application", 86400)); server.enqueue(200, "[]"); server.enqueue(200, "[]");
            try (SiigoApi api = builder(server).setTokenProvider(() -> {
                if (token.get() == null) token.set(owner.get().getAuthenticationService().authenticate(credentials()).getAccessToken());
                return token.get();
            }).build()) {
                owner.set(api); api.getCatalogService().getTaxes();
                token.set("replaced-by-application"); api.getCatalogService().getTaxes();
            }
            assertEquals(3, server.requests.size());
            assertEquals("Bearer replaced-by-application", server.requests.getLast().header("Authorization"));
        }
    }
    @Test void closePreventsFurtherHttpRequests() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            SiigoApi api = builder(server).setAccessToken("manual").build(); api.close(); api.close();
            assertThrows(SiigoApiException.class, () -> api.getCatalogService().getTaxes());
            assertTrue(server.requests.isEmpty());
        }
    }
    private static final class MutableClock extends Clock {
        private Instant now = Instant.parse("2026-01-01T00:00:00Z");
        void advance(long seconds) { now = now.plusSeconds(seconds); }
        @Override public ZoneId getZone() { return ZoneOffset.UTC; }
        @Override public Clock withZone(ZoneId zone) { return this; }
        @Override public Instant instant() { return now; }
    }
}
