package co.gldconsulting.siigo.service;

import com.fasterxml.jackson.databind.JsonNode;
import java.time.Instant;

/** HTTP status zero identifies a transport or decoding failure. */
public final class SiigoApiError {
    private final int statusCode;
    private final String method;
    private final String path;
    private final String message;
    private final JsonNode details;
    private final Instant timestamp = Instant.now();
    public SiigoApiError(int statusCode, String method, String path, String message, JsonNode details) {
        this.statusCode = statusCode; this.method = method; this.path = path; this.message = message; this.details = details;
    }
    public int getStatusCode() { return statusCode; }
    public String getMethod() { return method; }
    public String getPath() { return path; }
    public String getMessage() { return message; }
    public JsonNode getDetails() { return details; }
    public Instant getTimestamp() { return timestamp; }
}
