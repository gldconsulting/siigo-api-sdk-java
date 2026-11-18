package co.gldconsulting.siigo.resource;

import co.gldconsulting.siigo.model.Authentication;
import co.gldconsulting.siigo.model.AuthenticationCredentials;
import retrofit2.http.Body;
import retrofit2.http.POST;
/** Authentication has Partner-Id automatically, and never Bearer authentication. */
public interface AuthenticationResource {
    @POST("auth") Authentication authenticate(@Body AuthenticationCredentials credentials);
}
