package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.AccountsPayableResponse;
import co.gldconsulting.siigo.model.ReportResponse;
import co.gldconsulting.siigo.model.TestBalanceRequest;
import co.gldconsulting.siigo.model.ThirdPartyTestBalanceRequest;
import co.gldconsulting.siigo.resource.reporting.ReportResource;
import co.gldconsulting.siigo.service.reporting.AccountsPayableFilter;
import co.gldconsulting.siigo.service.reporting.ReportService;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class ReportServiceImpl implements ReportService {
    private final ReportResource resource;
    ReportServiceImpl(ReportResource resource) { this.resource = resource; }
    @Override public ReportResponse getTestBalance(TestBalanceRequest request) { return resource.getTestBalance(Objects.requireNonNull(request, "request")); }
    @Override public ReportResponse getThirdPartyTestBalance(ThirdPartyTestBalanceRequest request) { return resource.getThirdPartyTestBalance(Objects.requireNonNull(request, "request")); }
    @Override public AccountsPayableResponse getAccountsPayable(AccountsPayableFilter filter) { return resource.getAccountsPayable(Objects.requireNonNull(filter, "filter").toQueryMap()); }
}
