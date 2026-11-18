package co.gldconsulting.siigo.service;

/** Supplies the token currently owned by the application. Tokens must not include the Bearer prefix. */
@FunctionalInterface
public interface TokenProvider {
    String getAccessToken();
    /**
     * Optional lifecycle hook. Return true only when a new token is available and a rejected
     * read may be retried. The default leaves lifecycle management entirely to the application.
     * @param rejectedToken token rejected by the server
     * @return whether one read retry is allowed
     */
    default boolean refreshAfterUnauthorized(String rejectedToken) { return false; }
}
