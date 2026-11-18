package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/** Server pagination metadata. */
public class Pagination {
    private Integer page;
    @JsonProperty("page_size") private Integer pageSize;
    @JsonProperty("total_results") private Long totalResults;
    public Integer getPage() { return page; }
    public Pagination setPage(Integer value) { page = value; return this; }
    public Integer getPageSize() { return pageSize; }
    public Pagination setPageSize(Integer value) { pageSize = value; return this; }
    public Long getTotalResults() { return totalResults; }
    public Pagination setTotalResults(Long value) { totalResults = value; return this; }
}
