package co.gldconsulting.siigo;

import java.time.Duration;
import java.util.Objects;

final class Preconditions {
    private Preconditions() { }
    static String text(String value, String name) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException(name + " must not be blank");
        return value;
    }
    static Duration positive(Duration value, String name) {
        Objects.requireNonNull(value, name);
        if (value.isNegative() || value.isZero()) throw new IllegalArgumentException(name + " must be positive");
        return value;
    }
    static String id(String value) {
        text(value, "id");
        if (value.contains("/") || value.equals(".") || value.equals("..")) throw new IllegalArgumentException("id must be a single path segment");
        return value;
    }
    static Long id(Long value) {
        if (value == null || value <= 0) throw new IllegalArgumentException("id must be positive");
        return value;
    }
    static String idempotency(String key) {
        if (key != null && !key.matches("[A-Za-z0-9]{1,30}")) throw new IllegalArgumentException("Idempotency key must be 1–30 alphanumeric characters");
        return key;
    }
}
