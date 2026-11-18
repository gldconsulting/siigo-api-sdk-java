package co.gldconsulting.siigo.resource.reporting;

import co.gldconsulting.siigo.model.AccountsPayableResponse;
import co.gldconsulting.siigo.model.ReportResponse;
import co.gldconsulting.siigo.model.TestBalanceRequest;
import co.gldconsulting.siigo.model.ThirdPartyTestBalanceRequest;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface ReportResource {
    @POST("v1/test-balance-report")
    ReportResponse getTestBalance(@Body TestBalanceRequest request);
    @POST("v1/test-balance-report-by-thirdparty")
    ReportResponse getThirdPartyTestBalance(@Body ThirdPartyTestBalanceRequest request);
    @GET("v1/accounts-payable")
    AccountsPayableResponse getAccountsPayable(@QueryMap Map<String, String> query);
}
