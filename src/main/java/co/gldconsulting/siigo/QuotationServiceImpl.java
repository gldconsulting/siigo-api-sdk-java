package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Quotation;
import co.gldconsulting.siigo.model.QuotationRequest;
import co.gldconsulting.siigo.model.QuotationsResponse;
import co.gldconsulting.siigo.resource.accounting.QuotationResource;
import co.gldconsulting.siigo.service.accounting.QuotationService;
import co.gldconsulting.siigo.service.accounting.QuotationsFilter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class QuotationServiceImpl implements QuotationService {
    private final QuotationResource resource;
    QuotationServiceImpl(QuotationResource resource) { this.resource = resource; }
    @Override public QuotationsResponse getQuotations(QuotationsFilter filter) { return resource.getQuotations(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public Quotation getQuotation(String id) { return resource.getQuotation(Preconditions.id(id)); }
    @Override public Quotation createQuotation(QuotationRequest request) { return resource.createQuotation(Objects.requireNonNull(request, "request")); }
    @Override public Quotation updateQuotation(String id, QuotationRequest request) { return resource.updateQuotation(Preconditions.id(id), Objects.requireNonNull(request, "request")); }
    @Override public DeleteResponse deleteQuotation(String id) { return resource.deleteQuotation(Preconditions.id(id)); }
    @Override public List<Quotation> getAllQuotations(QuotationsFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getQuotations, Quotation::getId); }
}
