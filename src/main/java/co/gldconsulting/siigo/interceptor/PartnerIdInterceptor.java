package co.gldconsulting.siigo.interceptor;

import java.io.IOException;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.Response;

/** Adds the application's immutable Partner-Id to authentication and API calls. */
public final class PartnerIdInterceptor implements Interceptor {
    private final String partnerId;
    public PartnerIdInterceptor(String partnerId) {
        this.partnerId = Objects.requireNonNull(partnerId);
        if (partnerId.isBlank()) throw new IllegalArgumentException("partnerId must not be blank");
    }
    @Override public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().header("Partner-Id", partnerId).build());
    }
}
