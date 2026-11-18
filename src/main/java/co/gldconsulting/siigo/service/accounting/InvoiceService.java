package co.gldconsulting.siigo.service.accounting;

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
import java.util.List;

/** Siigo Invoice operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface InvoiceService {
    InvoicesResponse getInvoices(InvoicesFilter filter);
    default InvoicesResponse getInvoices() { return getInvoices(new InvoicesFilter()); }
    Invoice getInvoice(String id);
    Invoice createInvoice(InvoiceRequest request, String idempotencyKey);
    default Invoice createInvoice(InvoiceRequest request) { return createInvoice(request, null); }
    Invoice updateInvoice(String id, InvoiceRequest request);
    DeleteResponse deleteInvoice(String id);
    default List<Invoice> getAllInvoices() { return getAllInvoices(new InvoicesFilter()); }
    List<Invoice> getAllInvoices(InvoicesFilter filter);
    DeleteResponse annulInvoice(String id);
    ElectronicErrors getElectronicErrors(String id);
    DocumentFile getInvoicePdf(String id);
    DocumentFile getInvoiceXml(String id);
    MailResponse sendInvoiceByEmail(String id, InvoiceMailRequest request);
    InvoiceBatchResponse createInvoiceBatch(InvoiceBatchRequest request);
}
