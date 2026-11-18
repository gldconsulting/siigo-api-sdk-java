package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.CreditNote;
import co.gldconsulting.siigo.model.CreditNoteRequest;
import co.gldconsulting.siigo.model.CreditNotesResponse;
import co.gldconsulting.siigo.model.DocumentFile;
import java.util.List;

/** Siigo CreditNote operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface CreditNoteService {
    CreditNotesResponse getCreditNotes(CreditNotesFilter filter);
    default CreditNotesResponse getCreditNotes() { return getCreditNotes(new CreditNotesFilter()); }
    CreditNote getCreditNote(String id);
    CreditNote createCreditNote(CreditNoteRequest request, String idempotencyKey);
    default CreditNote createCreditNote(CreditNoteRequest request) { return createCreditNote(request, null); }
    default List<CreditNote> getAllCreditNotes() { return getAllCreditNotes(new CreditNotesFilter()); }
    List<CreditNote> getAllCreditNotes(CreditNotesFilter filter);
    DocumentFile getCreditNotePdf(String id);
}
