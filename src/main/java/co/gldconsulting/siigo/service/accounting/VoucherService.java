package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.Voucher;
import co.gldconsulting.siigo.model.VoucherRequest;
import co.gldconsulting.siigo.model.VouchersResponse;
import java.util.List;

/** Siigo Voucher operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface VoucherService {
    VouchersResponse getVouchers(VouchersFilter filter);
    default VouchersResponse getVouchers() { return getVouchers(new VouchersFilter()); }
    Voucher getVoucher(String id);
    Voucher createVoucher(VoucherRequest request, String idempotencyKey);
    default Voucher createVoucher(VoucherRequest request) { return createVoucher(request, null); }
    default List<Voucher> getAllVouchers() { return getAllVouchers(new VouchersFilter()); }
    List<Voucher> getAllVouchers(VouchersFilter filter);
    Voucher createMiscIncome(VoucherRequest request, String idempotencyKey);
    default Voucher createMiscIncome(VoucherRequest request) { return createMiscIncome(request, null); }
}
