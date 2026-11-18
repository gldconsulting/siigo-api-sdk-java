package co.gldconsulting.siigo.service;

import co.gldconsulting.siigo.model.PagedResponse;
import co.gldconsulting.siigo.model.Pagination;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;

/** Lazy, verified pagination. Contradictions fail instead of silently truncating a list. */
public final class PageIterator<T> implements Iterator<T> {
    private final IntFunction<? extends PagedResponse<T>> loader;
    private final Function<T, ?> identity;
    private final int size;
    private final Set<Object> seen = new HashSet<>();
    private Iterator<T> current = Collections.emptyIterator();
    private int nextPage = 1;
    private long scanned;
    private Long total;
    private boolean complete;
    public PageIterator(IntFunction<? extends PagedResponse<T>> loader, int size, Function<T, ?> identity) {
        if (size < 1 || size > 100) throw new IllegalArgumentException("pageSize must be between 1 and 100");
        this.loader = java.util.Objects.requireNonNull(loader); this.size = size; this.identity = java.util.Objects.requireNonNull(identity);
    }
    @Override public boolean hasNext() {
        while (!current.hasNext() && !complete) fetch();
        return current.hasNext();
    }
    @Override public T next() { if (!hasNext()) throw new NoSuchElementException(); return current.next(); }
    private void fetch() {
        PagedResponse<T> response = loader.apply(nextPage);
        Pagination meta = response == null ? null : response.getPagination();
        if (meta == null || meta.getPage() == null || meta.getPageSize() == null || meta.getTotalResults() == null
                || meta.getPage() != nextPage || meta.getPageSize() != size || meta.getTotalResults() < 0) fail("Invalid pagination metadata");
        if (total != null && !total.equals(meta.getTotalResults())) fail("total_results changed during pagination");
        long expectedTotal = meta.getTotalResults();
        List<T> rows = response.getResults();
        long expected = Math.min(size, Math.max(0, expectedTotal - (long) (nextPage - 1) * size));
        if (rows == null || rows.size() != expected) fail("Results do not match pagination metadata");
        Set<Object> nextSeen = new HashSet<>(seen);
        for (T row : rows) {
            Object id = row == null ? null : identity.apply(row);
            if (id == null || id.toString().isBlank()) fail("A result has no identifier");
            if (!nextSeen.add(id)) fail("Duplicate identifier across pages: " + id);
        }
        long nextScanned = scanned + rows.size();
        boolean last = (long) nextPage * size >= expectedTotal;
        if (last && nextScanned != expectedTotal) fail("Scanned count does not match total_results");
        if (last && response.getLinks() != null && response.getLinks().get("next") != null
                && response.getLinks().get("next").getHref() != null && !response.getLinks().get("next").getHref().isBlank()) fail("Unexpected next link on the last page");
        seen.clear(); seen.addAll(nextSeen); total = expectedTotal; scanned = nextScanned;
        complete = last; nextPage++; current = rows.iterator();
    }
    private static void fail(String message) { throw new IllegalStateException(message); }
}
