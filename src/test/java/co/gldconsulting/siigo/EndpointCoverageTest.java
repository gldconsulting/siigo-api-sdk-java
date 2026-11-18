package co.gldconsulting.siigo;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import retrofit2.http.Header;
import static org.junit.jupiter.api.Assertions.*;

class EndpointCoverageTest {
    @Test void everyAuditedContractHasAResourceAndSharedHeadersAreNeverMethodArguments() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        var inventory = mapper.readTree(getClass().getResourceAsStream("/siigo-api-coverage.json"));
        Set<String> actual = new HashSet<>(); Set<Class<?>> resources = new HashSet<>();
        for (var entry : inventory.get("operations")) resources.add(Class.forName(entry.get("resource").asText()));
        for (Class<?> resource : resources) for (Method method : resource.getDeclaredMethods()) {
            for (Annotation a : method.getAnnotations()) {
                String verb = a.annotationType().getSimpleName();
                if (Set.of("GET", "POST", "PUT", "DELETE").contains(verb)) {
                    String path = a.annotationType().getMethod("value").invoke(a).toString().split("\\?")[0];
                    actual.add(verb + " /" + path);
                }
            }
            for (Annotation[] parameter : method.getParameterAnnotations()) for (Annotation a : parameter) if (a instanceof Header h) {
                assertNotEquals("Authorization", h.value()); assertNotEquals("Partner-Id", h.value());
            }
            assertFalse(resource.getPackageName().contains(".client"));
        }
        Set<String> expected;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/expected-siigo-endpoints.txt"), StandardCharsets.UTF_8))) { expected = reader.lines().collect(Collectors.toSet()); }
        assertEquals(expected, actual);
        assertEquals(69, actual.size());
    }
}
