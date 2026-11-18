package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.SupportDocument;
import co.gldconsulting.siigo.model.SupportDocumentRequest;
import java.util.List;

/** Siigo SupportDocument operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface SupportDocumentService {
    SupportDocument createSupportDocument(SupportDocumentRequest request);
    SupportDocument getSupportDocument(String id);
    DeleteResponse deleteSupportDocument(String id);
    SupportDocument updateSupportDocument(String id, SupportDocumentRequest request);
}
