package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.LinkedHashMap;
import java.util.Map;

/** Preserves vendor extensions without requiring a new SDK release for every optional field. */
public abstract class ApiModel {
    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();
    @JsonAnyGetter public Map<String, JsonNode> getAdditionalProperties() { return additionalProperties; }
    @JsonAnySetter public void setAdditionalProperty(String name, JsonNode value) { additionalProperties.put(name, value); }
}
