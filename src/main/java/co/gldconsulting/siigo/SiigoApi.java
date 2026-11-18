package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.resource.accounting.CreditNoteResource;
import co.gldconsulting.siigo.resource.accounting.CustomerResource;
import co.gldconsulting.siigo.resource.accounting.InvoiceResource;
import co.gldconsulting.siigo.resource.accounting.JournalResource;
import co.gldconsulting.siigo.resource.accounting.PaymentReceiptResource;
import co.gldconsulting.siigo.resource.accounting.ProductResource;
import co.gldconsulting.siigo.resource.accounting.PurchaseResource;
import co.gldconsulting.siigo.resource.accounting.QuotationResource;
import co.gldconsulting.siigo.resource.accounting.SupportDocumentResource;
import co.gldconsulting.siigo.resource.accounting.VoucherResource;
import co.gldconsulting.siigo.resource.accounting.WebhookResource;
import co.gldconsulting.siigo.resource.catalog.CatalogResource;
import co.gldconsulting.siigo.resource.catalog.InventoryCategoryResource;
import co.gldconsulting.siigo.resource.reporting.ReportResource;
import co.gldconsulting.siigo.service.AuthenticationService;
import co.gldconsulting.siigo.service.TokenProvider;
import co.gldconsulting.siigo.service.accounting.CreditNoteService;
import co.gldconsulting.siigo.service.accounting.CustomerService;
import co.gldconsulting.siigo.service.accounting.InvoiceService;
import co.gldconsulting.siigo.service.accounting.JournalService;
import co.gldconsulting.siigo.service.accounting.PaymentReceiptService;
import co.gldconsulting.siigo.service.accounting.ProductService;
import co.gldconsulting.siigo.service.accounting.PurchaseService;
import co.gldconsulting.siigo.service.accounting.QuotationService;
import co.gldconsulting.siigo.service.accounting.SupportDocumentService;
import co.gldconsulting.siigo.service.accounting.VoucherService;
import co.gldconsulting.siigo.service.accounting.WebhookService;
import co.gldconsulting.siigo.service.catalog.CatalogService;
import co.gldconsulting.siigo.service.catalog.InventoryCategoryService;
import co.gldconsulting.siigo.service.reporting.ReportService;
import java.util.Objects;

/** Entry point to Siigo API Colombia. One instance shares partner configuration and a token session. */
public final class SiigoApi implements AutoCloseable {
    private final CommunicationFactory factory;
    private final AuthenticationService authenticationService;
    private final ProductService productService;
    private final CustomerService customerService;
    private final InvoiceService invoiceService;
    private final QuotationService quotationService;
    private final CreditNoteService creditNoteService;
    private final PurchaseService purchaseService;
    private final JournalService journalService;
    private final VoucherService voucherService;
    private final SupportDocumentService supportDocumentService;
    private final PaymentReceiptService paymentReceiptService;
    private final InventoryCategoryService inventoryCategoryService;
    private final CatalogService catalogService;
    private final ReportService reportService;
    private final WebhookService webhookService;

    private SiigoApi(CommunicationFactory factory) {
        this.factory = factory;
        authenticationService = new AuthenticationServiceImpl(factory.getAuthentication());
        productService = new ProductServiceImpl(factory.createEndpoint(ProductResource.class));
        customerService = new CustomerServiceImpl(factory.createEndpoint(CustomerResource.class));
        invoiceService = new InvoiceServiceImpl(factory.createEndpoint(InvoiceResource.class));
        quotationService = new QuotationServiceImpl(factory.createEndpoint(QuotationResource.class));
        creditNoteService = new CreditNoteServiceImpl(factory.createEndpoint(CreditNoteResource.class));
        purchaseService = new PurchaseServiceImpl(factory.createEndpoint(PurchaseResource.class));
        journalService = new JournalServiceImpl(factory.createEndpoint(JournalResource.class));
        voucherService = new VoucherServiceImpl(factory.createEndpoint(VoucherResource.class));
        supportDocumentService = new SupportDocumentServiceImpl(factory.createEndpoint(SupportDocumentResource.class));
        paymentReceiptService = new PaymentReceiptServiceImpl(factory.createEndpoint(PaymentReceiptResource.class));
        inventoryCategoryService = new InventoryCategoryServiceImpl(factory.createEndpoint(InventoryCategoryResource.class));
        catalogService = new CatalogServiceImpl(factory.createEndpoint(CatalogResource.class));
        reportService = new ReportServiceImpl(factory.createEndpoint(ReportResource.class));
        webhookService = new WebhookServiceImpl(factory.createEndpoint(WebhookResource.class));
    }

    public AuthenticationService getAuthenticationService() { return authenticationService; }
    public ProductService getProductService() { return productService; }
    public CustomerService getCustomerService() { return customerService; }
    public InvoiceService getInvoiceService() { return invoiceService; }
    public QuotationService getQuotationService() { return quotationService; }
    public CreditNoteService getCreditNoteService() { return creditNoteService; }
    public PurchaseService getPurchaseService() { return purchaseService; }
    public JournalService getJournalService() { return journalService; }
    public VoucherService getVoucherService() { return voucherService; }
    public SupportDocumentService getSupportDocumentService() { return supportDocumentService; }
    public PaymentReceiptService getPaymentReceiptService() { return paymentReceiptService; }
    public InventoryCategoryService getInventoryCategoryService() { return inventoryCategoryService; }
    public CatalogService getCatalogService() { return catalogService; }
    public ReportService getReportService() { return reportService; }
    public WebhookService getWebhookService() { return webhookService; }
    /** Replace the shared token and switch to application-owned lifecycle management. */
    public void setAccessToken(String token) { factory.getAuthentication().setAccessToken(token); }
    /** Use a provider owned by the application; the default lifecycle hook performs no renewal. */
    public void setTokenProvider(TokenProvider provider) { factory.getAuthentication().setTokenProvider(provider); }
    /** Resume the built-in lifecycle with previously configured credentials. */
    public void useAutomaticAuthentication() { factory.getAuthentication().useAutomaticAuthentication(); }
    public <T> T createEndpoint(Class<T> resourceType) { return factory.createEndpoint(resourceType); }
    @Override public void close() { factory.close(); }
    public static Builder builder() { return new Builder(); }
    public static final class Builder {
        private CommunicationConfig communication;
        private SerializationConfig serialization = SerializationConfig.builder().build();
        private AuthenticationCredentials credentials;
        private String token;
        private TokenProvider provider;
        public Builder setCommunicationConfig(CommunicationConfig value) { communication = Objects.requireNonNull(value); return this; }
        public Builder withCommunicationConfig(CommunicationConfig.Builder value) { return setCommunicationConfig(value.build()); }
        public Builder setSerializationConfig(SerializationConfig value) { serialization = Objects.requireNonNull(value); return this; }
        public Builder withSerializationConfig(SerializationConfig.Builder value) { return setSerializationConfig(value.build()); }
        public Builder setCredentials(AuthenticationCredentials value) { credentials = Objects.requireNonNull(value); return this; }
        public Builder setAccessToken(String value) { token = Preconditions.text(value, "accessToken"); provider = null; return this; }
        public Builder setTokenProvider(TokenProvider value) { provider = Objects.requireNonNull(value); token = null; return this; }
        public SiigoApi build() {
            if (communication == null) throw new IllegalStateException("Configure CommunicationConfig with the application's Partner-Id");
            CommunicationFactory factory = new CommunicationFactory(communication, new SerializationFactory(serialization).getObjectMapper(), credentials, token);
            if (provider != null) factory.getAuthentication().setTokenProvider(provider);
            return new SiigoApi(factory);
        }
    }
}
