package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class User extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("username") private String username;
    @JsonProperty("first_name") private String firstName;
    @JsonProperty("last_name") private String lastName;
    @JsonProperty("email") private String email;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("identification") private String identification;

    public Long getId() { return id; }
    public User setId(Long value) { this.id = value; return this; }
    public String getUsername() { return username; }
    public User setUsername(String value) { this.username = value; return this; }
    public String getFirstName() { return firstName; }
    public User setFirstName(String value) { this.firstName = value; return this; }
    public String getLastName() { return lastName; }
    public User setLastName(String value) { this.lastName = value; return this; }
    public String getEmail() { return email; }
    public User setEmail(String value) { this.email = value; return this; }
    public Boolean getActive() { return active; }
    public User setActive(Boolean value) { this.active = value; return this; }
    public String getIdentification() { return identification; }
    public User setIdentification(String value) { this.identification = value; return this; }
}
