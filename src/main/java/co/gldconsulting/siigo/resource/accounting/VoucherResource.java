package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.Voucher;
import co.gldconsulting.siigo.model.VoucherRequest;
import co.gldconsulting.siigo.model.VouchersResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface VoucherResource {
    @GET("v1/vouchers")
    VouchersResponse getVouchers(@QueryMap Map<String, String> query);
    @GET("v1/vouchers/{id}")
    Voucher getVoucher(@Path("id") String id);
    @POST("v1/vouchers")
    Voucher createVoucher(@Body VoucherRequest request, @Header("Idempotency-Key") String idempotencyKey);
    @POST("v1/vouchers?type=MiscIncome")
    Voucher createMiscIncome(@Body VoucherRequest request, @Header("Idempotency-Key") String idempotencyKey);
}
