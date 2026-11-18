package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.Journal;
import co.gldconsulting.siigo.model.JournalRequest;
import co.gldconsulting.siigo.model.JournalsResponse;
import java.util.List;
import java.time.LocalDate;

/** Siigo Journal operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface JournalService {
    JournalsResponse getJournals(JournalsFilter filter);
    default JournalsResponse getJournals() { return getJournals(new JournalsFilter()); }
    Journal getJournal(String id);
    Journal createJournal(JournalRequest request, String idempotencyKey);
    default Journal createJournal(JournalRequest request) { return createJournal(request, null); }
    default List<Journal> getAllJournals() { return getAllJournals(new JournalsFilter()); }
    List<Journal> getAllJournals(JournalsFilter filter);
    /** Inclusive document-date selection after verified full pagination; avoids unreliable remote date filters. */
    default List<Journal> getJournalsByDate(LocalDate from, LocalDate to) { return getJournalsByDate(from, to, new JournalsFilter()); }
    /** The filter may configure pagination and other remote filters; date_start/date_end must be supplied via from/to only. */
    List<Journal> getJournalsByDate(LocalDate from, LocalDate to, JournalsFilter filter);
}
