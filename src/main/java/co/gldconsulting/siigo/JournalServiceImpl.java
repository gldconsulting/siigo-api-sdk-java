package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.Journal;
import co.gldconsulting.siigo.model.JournalRequest;
import co.gldconsulting.siigo.model.JournalsResponse;
import co.gldconsulting.siigo.resource.accounting.JournalResource;
import co.gldconsulting.siigo.service.accounting.JournalService;
import co.gldconsulting.siigo.service.accounting.JournalsFilter;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

final class JournalServiceImpl implements JournalService {
    private final JournalResource resource;
    JournalServiceImpl(JournalResource resource) { this.resource = resource; }
    @Override public JournalsResponse getJournals(JournalsFilter filter) { return resource.getJournals(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public Journal getJournal(String id) { return resource.getJournal(Preconditions.id(id)); }
    @Override public Journal createJournal(JournalRequest request, String idempotencyKey) { return resource.createJournal(Objects.requireNonNull(request, "request"), Preconditions.idempotency(idempotencyKey)); }
    @Override public List<Journal> getAllJournals(JournalsFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getJournals, Journal::getId); }
    @Override public List<Journal> getJournalsByDate(LocalDate from, LocalDate to, JournalsFilter filter) {
        Objects.requireNonNull(from, "from"); Objects.requireNonNull(to, "to"); Objects.requireNonNull(filter, "filter");
        if (from.isAfter(to)) throw new IllegalArgumentException("from must be on or before to");
        Map<String, String> query = filter.toQueryMap();
        if (query.containsKey("date_start") || query.containsKey("date_end"))
            throw new IllegalArgumentException("Supply document dates through from/to, without remote date_start/date_end filters");
        return getAllJournals(filter).stream().filter(journal -> {
            if (journal.getDate() == null) throw new IllegalStateException("A journal has no document date");
            return !journal.getDate().isBefore(from) && !journal.getDate().isAfter(to);
        }).toList();
    }
}
