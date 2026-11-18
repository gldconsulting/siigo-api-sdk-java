package co.gldconsulting.siigo;

import co.gldconsulting.siigo.interceptor.AuthenticationInterceptor;
import co.gldconsulting.siigo.interceptor.PartnerIdInterceptor;
import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.resource.AuthenticationResource;
import co.gldconsulting.siigo.service.SiigoApiError;
import co.gldconsulting.siigo.service.SiigoApiException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

final class CommunicationFactory implements AutoCloseable {
    private final java.util.concurrent.atomic.AtomicBoolean closed = new java.util.concurrent.atomic.AtomicBoolean();
    private final OkHttpClient authClient;
    private final OkHttpClient apiClient;
    private final Retrofit api;
    private final AuthenticationManager authentication;
    CommunicationFactory(CommunicationConfig config, ObjectMapper mapper, AuthenticationCredentials credentials, String token) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(config.getHttpLogger());
        logging.redactHeader("Authorization"); logging.redactHeader("Partner-Id");
        logging.setLevel(config.isDebug() ? HttpLoggingInterceptor.Level.HEADERS : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .followRedirects(false).followSslRedirects(false).retryOnConnectionFailure(false)
                .connectTimeout(config.getConnectTimeout()).readTimeout(config.getReadTimeout()).writeTimeout(config.getWriteTimeout())
                .addInterceptor(chain -> { if (closed.get()) throw new IOException("SiigoApi is closed"); return chain.proceed(chain.request()); })
                .addInterceptor(new PartnerIdInterceptor(config.getPartnerId()))
                .addInterceptor(chain -> chain.proceed(chain.request().newBuilder().header("User-Agent", config.getUserAgent()).build()));
        config.getInterceptors().forEach(builder::addInterceptor);
        authClient = builder.addInterceptor(logging).build();
        Retrofit auth = retrofit(config.getApiUrl(), authClient, mapper);
        authentication = new AuthenticationManager(auth.create(AuthenticationResource.class), config.getClock(), credentials, token);
        apiClient = authClient.newBuilder().addInterceptor(new AuthenticationInterceptor(authentication)).build();
        api = retrofit(config.getApiUrl(), apiClient, mapper);
    }
    private static Retrofit retrofit(String url, OkHttpClient client, ObjectMapper mapper) {
        return new Retrofit.Builder().baseUrl(url).client(client).addConverterFactory(JacksonConverterFactory.create(mapper))
                .addCallAdapterFactory(new SynchronousAdapterFactory(mapper)).build();
    }
    <T> T createEndpoint(Class<T> type) { return api.create(type); }
    AuthenticationManager getAuthentication() { return authentication; }
    @Override public void close() {
        if (!closed.compareAndSet(false, true)) return;
        apiClient.dispatcher().executorService().shutdown(); apiClient.connectionPool().evictAll();
        if (apiClient.cache() != null) try { apiClient.cache().close(); } catch (IOException ignored) { /* Closing the transport is best effort. */ }
    }
    private static final class SynchronousAdapterFactory extends CallAdapter.Factory {
        private final ObjectMapper mapper;
        SynchronousAdapterFactory(ObjectMapper mapper) { this.mapper = mapper; }
        @Override public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
            if (getRawType(returnType) == Call.class) return null;
            return new CallAdapter<Object, Object>() {
                @Override public Type responseType() { return returnType; }
                @Override public Object adapt(Call<Object> call) {
                    String method = call.request().method(), path = call.request().url().encodedPath();
                    try {
                        Response<Object> result = call.execute();
                        if (result.isSuccessful()) return result.body();
                        JsonNode details = null;
                        try (ResponseBody body = result.errorBody()) {
                            if (body != null) {
                                String text = body.string();
                                try { details = mapper.readTree(text); } catch (IOException ignored) { /* Preserve status even for non-JSON errors. */ }
                            }
                        }
                        throw new SiigoApiException(new SiigoApiError(result.code(), method, path, "Siigo responded HTTP " + result.code(), details));
                    } catch (IOException ex) {
                        throw new SiigoApiException(new SiigoApiError(0, method, path, "Siigo transport or response decoding failed", null), ex);
                    }
                }
            };
        }
    }
}
