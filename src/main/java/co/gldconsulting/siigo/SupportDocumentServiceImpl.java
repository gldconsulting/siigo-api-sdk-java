package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.SupportDocument;
import co.gldconsulting.siigo.model.SupportDocumentRequest;
import co.gldconsulting.siigo.resource.accounting.SupportDocumentResource;
import co.gldconsulting.siigo.service.accounting.SupportDocumentService;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class SupportDocumentServiceImpl implements SupportDocumentService {
    private final SupportDocumentResource resource;
    SupportDocumentServiceImpl(SupportDocumentResource resource) { this.resource = resource; }
    @Override public SupportDocument createSupportDocument(SupportDocumentRequest request) { return resource.createSupportDocument(Objects.requireNonNull(request, "request")); }
    @Override public SupportDocument getSupportDocument(String id) { return resource.getSupportDocument(Preconditions.id(id)); }
    @Override public DeleteResponse deleteSupportDocument(String id) { return resource.deleteSupportDocument(Preconditions.id(id)); }
    @Override public SupportDocument updateSupportDocument(String id, SupportDocumentRequest request) { return resource.updateSupportDocument(Preconditions.id(id), Objects.requireNonNull(request, "request")); }
}
