package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class Authentication extends ApiModel {
    @JsonProperty("access_token") private String accessToken;
    @JsonProperty("expires_in") private Long expiresIn;
    @JsonProperty("token_type") private String tokenType;
    @JsonProperty("scope") private String scope;

    public String getAccessToken() { return accessToken; }
    public Authentication setAccessToken(String value) { this.accessToken = value; return this; }
    public Long getExpiresIn() { return expiresIn; }
    public Authentication setExpiresIn(Long value) { this.expiresIn = value; return this; }
    public String getTokenType() { return tokenType; }
    public Authentication setTokenType(String value) { this.tokenType = value; return this; }
    public String getScope() { return scope; }
    public Authentication setScope(String value) { this.scope = value; return this; }
    @Override public String toString() { return "Authentication[redacted]"; }

}
