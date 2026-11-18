package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.AccountGroup;
import co.gldconsulting.siigo.model.AccountGroupRequest;
import co.gldconsulting.siigo.resource.catalog.InventoryCategoryResource;
import co.gldconsulting.siigo.service.catalog.InventoryCategoryService;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class InventoryCategoryServiceImpl implements InventoryCategoryService {
    private final InventoryCategoryResource resource;
    InventoryCategoryServiceImpl(InventoryCategoryResource resource) { this.resource = resource; }
    @Override public List<AccountGroup> getAccountGroups() { return resource.getAccountGroups(); }
    @Override public AccountGroup createAccountGroup(AccountGroupRequest request) { return resource.createAccountGroup(Objects.requireNonNull(request, "request")); }
    @Override public AccountGroup updateAccountGroup(Long id, AccountGroupRequest request) { return resource.updateAccountGroup(Preconditions.id(id), Objects.requireNonNull(request, "request")); }
}
