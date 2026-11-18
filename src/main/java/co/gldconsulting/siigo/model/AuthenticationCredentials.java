package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class AuthenticationCredentials extends ApiModel {
    @JsonProperty("username") private String username;
    @JsonProperty("access_key") private String accessKey;

    public String getUsername() { return username; }
    public AuthenticationCredentials setUsername(String value) { this.username = value; return this; }
    public String getAccessKey() { return accessKey; }
    public AuthenticationCredentials setAccessKey(String value) { this.accessKey = value; return this; }
    @Override public String toString() { return "AuthenticationCredentials[redacted]"; }

}
