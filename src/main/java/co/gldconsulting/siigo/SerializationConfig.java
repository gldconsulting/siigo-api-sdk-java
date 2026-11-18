package co.gldconsulting.siigo;

/** JSON configuration, independent from transport configuration. */
public final class SerializationConfig {
    private final boolean ignoreNullProperties;
    private final boolean failOnUnknownProperties;
    private SerializationConfig(Builder b) { ignoreNullProperties = b.ignoreNullProperties; failOnUnknownProperties = b.failOnUnknownProperties; }
    public boolean isIgnoreNullProperties() { return ignoreNullProperties; }
    public boolean isFailOnUnknownProperties() { return failOnUnknownProperties; }
    public static Builder builder() { return new Builder(); }
    public static final class Builder {
        private boolean ignoreNullProperties = true;
        private boolean failOnUnknownProperties;
        public Builder setIgnoreNullProperties(boolean value) { ignoreNullProperties = value; return this; }
        public Builder setFailOnUnknownProperties(boolean value) { failOnUnknownProperties = value; return this; }
        public SerializationConfig build() { return new SerializationConfig(this); }
    }
}
