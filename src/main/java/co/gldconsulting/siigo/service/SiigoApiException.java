package co.gldconsulting.siigo.service;

/** Structured API or transport failure. No request headers or credentials are retained. */
public class SiigoApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final SiigoApiError error;
    public SiigoApiException(SiigoApiError error) { super(error.getMessage()); this.error = error; }
    public SiigoApiException(SiigoApiError error, Throwable cause) { super(error.getMessage(), cause); this.error = error; }
    public SiigoApiError getError() { return error; }
    public int getStatusCode() { return error.getStatusCode(); }
}
