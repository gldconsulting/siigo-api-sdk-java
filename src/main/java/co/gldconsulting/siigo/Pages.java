package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.PagedResponse;
import co.gldconsulting.siigo.service.PageIterator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

final class Pages {
    private Pages() { }
    static <T> List<T> all(Map<String, String> original, Function<Map<String, String>, ? extends PagedResponse<T>> loader, Function<T, ?> identity) {
        Map<String, String> snapshot = new LinkedHashMap<>(original);
        int size = Integer.parseInt(snapshot.getOrDefault("page_size", "25"));
        PageIterator<T> iterator = new PageIterator<>(page -> {
            Map<String, String> query = new LinkedHashMap<>(snapshot);
            query.put("page", Integer.toString(page)); query.put("page_size", Integer.toString(size));
            return loader.apply(query);
        }, size, identity);
        List<T> results = new ArrayList<>(); iterator.forEachRemaining(results::add); return List.copyOf(results);
    }
}
