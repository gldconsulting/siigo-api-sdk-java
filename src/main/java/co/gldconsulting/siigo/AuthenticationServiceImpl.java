package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.Authentication;
import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.service.AuthenticationService;
final class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager manager;
    AuthenticationServiceImpl(AuthenticationManager manager) { this.manager = manager; }
    @Override public Authentication authenticate(AuthenticationCredentials credentials) { return manager.authenticate(credentials); }
}
