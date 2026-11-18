package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.CreditNote;
import co.gldconsulting.siigo.model.CreditNoteRequest;
import co.gldconsulting.siigo.model.CreditNotesResponse;
import co.gldconsulting.siigo.model.DocumentFile;
import co.gldconsulting.siigo.resource.accounting.CreditNoteResource;
import co.gldconsulting.siigo.service.accounting.CreditNoteService;
import co.gldconsulting.siigo.service.accounting.CreditNotesFilter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class CreditNoteServiceImpl implements CreditNoteService {
    private final CreditNoteResource resource;
    CreditNoteServiceImpl(CreditNoteResource resource) { this.resource = resource; }
    @Override public CreditNotesResponse getCreditNotes(CreditNotesFilter filter) { return resource.getCreditNotes(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public CreditNote getCreditNote(String id) { return resource.getCreditNote(Preconditions.id(id)); }
    @Override public CreditNote createCreditNote(CreditNoteRequest request, String idempotencyKey) { return resource.createCreditNote(Objects.requireNonNull(request, "request"), Preconditions.idempotency(idempotencyKey)); }
    @Override public List<CreditNote> getAllCreditNotes(CreditNotesFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getCreditNotes, CreditNote::getId); }
    @Override public DocumentFile getCreditNotePdf(String id) { return resource.getCreditNotePdf(Preconditions.id(id)); }
}
