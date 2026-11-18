package co.gldconsulting.siigo.service.catalog;

import co.gldconsulting.siigo.model.AccountGroup;
import co.gldconsulting.siigo.model.AccountGroupRequest;
import java.util.List;

/** Siigo InventoryCategory operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface InventoryCategoryService {
    List<AccountGroup> getAccountGroups();
    AccountGroup createAccountGroup(AccountGroupRequest request);
    AccountGroup updateAccountGroup(Long id, AccountGroupRequest request);
}
