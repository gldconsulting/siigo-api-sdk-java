package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.Voucher;
import co.gldconsulting.siigo.model.VoucherRequest;
import co.gldconsulting.siigo.model.VouchersResponse;
import co.gldconsulting.siigo.resource.accounting.VoucherResource;
import co.gldconsulting.siigo.service.accounting.VoucherService;
import co.gldconsulting.siigo.service.accounting.VouchersFilter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class VoucherServiceImpl implements VoucherService {
    private final VoucherResource resource;
    VoucherServiceImpl(VoucherResource resource) { this.resource = resource; }
    @Override public VouchersResponse getVouchers(VouchersFilter filter) { return resource.getVouchers(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public Voucher getVoucher(String id) { return resource.getVoucher(Preconditions.id(id)); }
    @Override public Voucher createVoucher(VoucherRequest request, String idempotencyKey) { return resource.createVoucher(Objects.requireNonNull(request, "request"), Preconditions.idempotency(idempotencyKey)); }
    @Override public List<Voucher> getAllVouchers(VouchersFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getVouchers, Voucher::getId); }
    @Override public Voucher createMiscIncome(VoucherRequest request, String idempotencyKey) { return resource.createMiscIncome(Objects.requireNonNull(request, "request"), Preconditions.idempotency(idempotencyKey)); }
}
