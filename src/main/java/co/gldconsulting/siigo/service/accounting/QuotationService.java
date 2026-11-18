package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Quotation;
import co.gldconsulting.siigo.model.QuotationRequest;
import co.gldconsulting.siigo.model.QuotationsResponse;
import java.util.List;

/** Siigo Quotation operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface QuotationService {
    QuotationsResponse getQuotations(QuotationsFilter filter);
    default QuotationsResponse getQuotations() { return getQuotations(new QuotationsFilter()); }
    Quotation getQuotation(String id);
    Quotation createQuotation(QuotationRequest request);
    Quotation updateQuotation(String id, QuotationRequest request);
    DeleteResponse deleteQuotation(String id);
    default List<Quotation> getAllQuotations() { return getAllQuotations(new QuotationsFilter()); }
    List<Quotation> getAllQuotations(QuotationsFilter filter);
}
