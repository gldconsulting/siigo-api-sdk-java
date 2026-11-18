package co.gldconsulting.siigo.service.reporting;

import co.gldconsulting.siigo.model.AccountsPayableResponse;
import co.gldconsulting.siigo.model.ReportResponse;
import co.gldconsulting.siigo.model.TestBalanceRequest;
import co.gldconsulting.siigo.model.ThirdPartyTestBalanceRequest;
import java.util.List;

/** Siigo Report operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface ReportService {
    ReportResponse getTestBalance(TestBalanceRequest request);
    ReportResponse getThirdPartyTestBalance(ThirdPartyTestBalanceRequest request);
    AccountsPayableResponse getAccountsPayable(AccountsPayableFilter filter);
    default AccountsPayableResponse getAccountsPayable() { return getAccountsPayable(new AccountsPayableFilter()); }
}
