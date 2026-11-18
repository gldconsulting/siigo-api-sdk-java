package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.DocumentFile;
import co.gldconsulting.siigo.model.ElectronicErrors;
import co.gldconsulting.siigo.model.Invoice;
import co.gldconsulting.siigo.model.InvoiceBatchRequest;
import co.gldconsulting.siigo.model.InvoiceBatchResponse;
import co.gldconsulting.siigo.model.InvoiceMailRequest;
import co.gldconsulting.siigo.model.InvoiceRequest;
import co.gldconsulting.siigo.model.InvoicesResponse;
import co.gldconsulting.siigo.model.MailResponse;
import co.gldconsulting.siigo.resource.accounting.InvoiceResource;
import co.gldconsulting.siigo.service.accounting.InvoiceService;
import co.gldconsulting.siigo.service.accounting.InvoicesFilter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceResource resource;
    InvoiceServiceImpl(InvoiceResource resource) { this.resource = resource; }
    @Override public InvoicesResponse getInvoices(InvoicesFilter filter) { return resource.getInvoices(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public Invoice getInvoice(String id) { return resource.getInvoice(Preconditions.id(id)); }
    @Override public Invoice createInvoice(InvoiceRequest request, String idempotencyKey) { return resource.createInvoice(Objects.requireNonNull(request, "request"), Preconditions.idempotency(idempotencyKey)); }
    @Override public Invoice updateInvoice(String id, InvoiceRequest request) { return resource.updateInvoice(Preconditions.id(id), Objects.requireNonNull(request, "request")); }
    @Override public DeleteResponse deleteInvoice(String id) { return resource.deleteInvoice(Preconditions.id(id)); }
    @Override public List<Invoice> getAllInvoices(InvoicesFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getInvoices, Invoice::getId); }
    @Override public DeleteResponse annulInvoice(String id) { return resource.annulInvoice(Preconditions.id(id)); }
    @Override public ElectronicErrors getElectronicErrors(String id) { return resource.getElectronicErrors(Preconditions.id(id)); }
    @Override public DocumentFile getInvoicePdf(String id) { return resource.getInvoicePdf(Preconditions.id(id)); }
    @Override public DocumentFile getInvoiceXml(String id) { return resource.getInvoiceXml(Preconditions.id(id)); }
    @Override public MailResponse sendInvoiceByEmail(String id, InvoiceMailRequest request) { return resource.sendInvoiceByEmail(Preconditions.id(id), Objects.requireNonNull(request, "request")); }
    @Override public InvoiceBatchResponse createInvoiceBatch(InvoiceBatchRequest request) { return resource.createInvoiceBatch(Objects.requireNonNull(request, "request")); }
}
