package co.gldconsulting.siigo.service;

import co.gldconsulting.siigo.model.Authentication;
import co.gldconsulting.siigo.model.AuthenticationCredentials;
/** Obtains authentication and updates the automatic cache, while preserving any manual token or external provider. */
public interface AuthenticationService {
    Authentication authenticate(AuthenticationCredentials credentials);
}
