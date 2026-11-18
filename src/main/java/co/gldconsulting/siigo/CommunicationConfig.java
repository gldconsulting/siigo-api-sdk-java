package co.gldconsulting.siigo;

import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

/** Immutable transport settings. Partner-Id is configured once here. */
public final class CommunicationConfig {
    private final Builder values;
    private CommunicationConfig(Builder source) { values = new Builder(source); }
    public static Builder builder() { return new Builder(); }
    public String getApiUrl() { return values.apiUrl; }
    public String getPartnerId() { return values.partnerId; }
    public String getUserAgent() { return values.userAgent; }
    public Duration getConnectTimeout() { return values.connectTimeout; }
    public Duration getReadTimeout() { return values.readTimeout; }
    public Duration getWriteTimeout() { return values.writeTimeout; }
    public List<Interceptor> getInterceptors() { return List.copyOf(values.interceptors); }
    public HttpLoggingInterceptor.Logger getHttpLogger() { return values.httpLogger; }
    public boolean isDebug() { return values.debug; }
    public Clock getClock() { return values.clock; }
    public static final class Builder {
        private String apiUrl = "https://api.siigo.com/";
        private String partnerId;
        private String userAgent = "GLD Siigo API SDK/1.0.0-SNAPSHOT";
        private Duration connectTimeout = Duration.ofSeconds(15);
        private Duration readTimeout = Duration.ofMinutes(2);
        private Duration writeTimeout = Duration.ofMinutes(2);
        private List<Interceptor> interceptors = new ArrayList<>();
        private HttpLoggingInterceptor.Logger httpLogger = message -> { };
        private boolean debug;
        private Clock clock = Clock.systemUTC();
        private Builder() { }
        private Builder(Builder b) {
            apiUrl = b.apiUrl; partnerId = b.partnerId; userAgent = b.userAgent;
            connectTimeout = b.connectTimeout; readTimeout = b.readTimeout; writeTimeout = b.writeTimeout;
            interceptors = new ArrayList<>(b.interceptors); httpLogger = b.httpLogger; debug = b.debug; clock = b.clock;
        }
        public Builder setApiUrl(String value) {
            HttpUrl url = HttpUrl.get(Preconditions.text(value, "apiUrl"));
            if (!url.username().isEmpty() || !url.password().isEmpty() || url.query() != null || url.fragment() != null) throw new IllegalArgumentException("apiUrl cannot contain credentials, a query or fragment");
            if (!url.isHttps() && !List.of("localhost", "127.0.0.1", "::1").contains(url.host())) throw new IllegalArgumentException("Remote API URLs must use HTTPS");
            apiUrl = url.toString().endsWith("/") ? url.toString() : url + "/"; return this;
        }
        public Builder setPartnerId(String value) { partnerId = Preconditions.text(value, "partnerId"); return this; }
        public Builder setUserAgent(String value) { userAgent = Preconditions.text(value, "userAgent"); return this; }
        public Builder setConnectTimeout(Duration value) { connectTimeout = Preconditions.positive(value, "connectTimeout"); return this; }
        public Builder setReadTimeout(Duration value) { readTimeout = Preconditions.positive(value, "readTimeout"); return this; }
        public Builder setWriteTimeout(Duration value) { writeTimeout = Preconditions.positive(value, "writeTimeout"); return this; }
        public Builder setInterceptors(List<Interceptor> value) { interceptors = new ArrayList<>(List.copyOf(value)); return this; }
        public Builder setHttpLogger(HttpLoggingInterceptor.Logger value) { httpLogger = Objects.requireNonNull(value); return this; }
        public Builder setDebug(boolean value) { debug = value; return this; }
        public Builder setClock(Clock value) { clock = Objects.requireNonNull(value); return this; }
        public CommunicationConfig build() { Preconditions.text(partnerId, "partnerId"); return new CommunicationConfig(this); }
    }
}
