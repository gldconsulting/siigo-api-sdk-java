package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
/** Typed Siigo results page. Both published link spellings are accepted. */
public class PagedResponse<T> extends ApiModel {
    private Pagination pagination;
    private List<T> results;
    @JsonProperty("_links") @JsonAlias("__links") private Map<String, Link> links;
    public Pagination getPagination() { return pagination; }
    public PagedResponse<T> setPagination(Pagination value) { pagination = value; return this; }
    public List<T> getResults() { return results; }
    public PagedResponse<T> setResults(List<T> value) { results = value; return this; }
    public Map<String, Link> getLinks() { return links; }
    public PagedResponse<T> setLinks(Map<String, Link> value) { links = value; return this; }
}
