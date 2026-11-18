package co.gldconsulting.siigo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

final class SerializationFactory {
    private final ObjectMapper mapper;
    SerializationFactory(SerializationConfig config) {
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, config.isFailOnUnknownProperties());
        if (config.isIgnoreNullProperties()) mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    ObjectMapper getObjectMapper() { return mapper; }
}
