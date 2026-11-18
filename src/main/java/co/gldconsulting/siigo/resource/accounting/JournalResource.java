package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.Journal;
import co.gldconsulting.siigo.model.JournalRequest;
import co.gldconsulting.siigo.model.JournalsResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface JournalResource {
    @GET("v1/journals")
    JournalsResponse getJournals(@QueryMap Map<String, String> query);
    @GET("v1/journals/{id}")
    Journal getJournal(@Path("id") String id);
    @POST("v1/journals")
    Journal createJournal(@Body JournalRequest request, @Header("Idempotency-Key") String idempotencyKey);
}
