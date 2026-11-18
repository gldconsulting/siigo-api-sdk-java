package co.gldconsulting.siigo.interceptor;

import co.gldconsulting.siigo.service.TokenProvider;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/** Injects Bearer authentication without adding authentication arguments to service methods. */
public final class AuthenticationInterceptor implements Interceptor {
    private final TokenProvider provider;
    public AuthenticationInterceptor(TokenProvider provider) { this.provider = Objects.requireNonNull(provider); }
    @Override public Response intercept(Chain chain) throws IOException {
        String token = token();
        Request request = chain.request().newBuilder().header("Authorization", "Bearer " + token).build();
        Response response = chain.proceed(request);
        if (response.code() == 401) {
            boolean refreshed = provider.refreshAfterUnauthorized(token);
            if (refreshed && (request.method().equals("GET") || request.method().equals("HEAD"))) {
                response.close();
                return chain.proceed(request.newBuilder().header("Authorization", "Bearer " + token()).build());
            }
        }
        return response;
    }
    private String token() {
        String value = provider.getAccessToken();
        if (value == null || value.isBlank()) throw new IllegalStateException("TokenProvider returned an empty token");
        return value;
    }
}
