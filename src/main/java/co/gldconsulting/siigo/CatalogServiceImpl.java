package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.CostCenter;
import co.gldconsulting.siigo.model.DocumentKind;
import co.gldconsulting.siigo.model.DocumentType;
import co.gldconsulting.siigo.model.Expense;
import co.gldconsulting.siigo.model.FixedAsset;
import co.gldconsulting.siigo.model.MiscIncome;
import co.gldconsulting.siigo.model.PaymentType;
import co.gldconsulting.siigo.model.PriceList;
import co.gldconsulting.siigo.model.Tax;
import co.gldconsulting.siigo.model.User;
import co.gldconsulting.siigo.model.UsersResponse;
import co.gldconsulting.siigo.model.Warehouse;
import co.gldconsulting.siigo.resource.catalog.CatalogResource;
import co.gldconsulting.siigo.service.catalog.CatalogService;
import co.gldconsulting.siigo.service.catalog.UsersFilter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class CatalogServiceImpl implements CatalogService {
    private final CatalogResource resource;
    CatalogServiceImpl(CatalogResource resource) { this.resource = resource; }
    @Override public List<Tax> getTaxes() { return resource.getTaxes(); }
    @Override public List<MiscIncome> getMiscIncomes() { return resource.getMiscIncomes(); }
    @Override public List<Expense> getExpenses() { return resource.getExpenses(); }
    @Override public List<Warehouse> getWarehouses() { return resource.getWarehouses(); }
    @Override public List<CostCenter> getCostCenters() { return resource.getCostCenters(); }
    @Override public List<PriceList> getPriceLists() { return resource.getPriceLists(); }
    @Override public List<FixedAsset> getFixedAssets() { return resource.getFixedAssets(); }
    @Override public List<DocumentType> getDocumentTypes(DocumentKind type) { return resource.getDocumentTypes(Objects.requireNonNull(type, "type")); }
    @Override public List<PaymentType> getPaymentTypes(DocumentKind documentType) { return resource.getPaymentTypes(Objects.requireNonNull(documentType, "documentType")); }
    @Override public UsersResponse getUsers(UsersFilter filter) { return resource.getUsers(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public List<User> getAllUsers(UsersFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getUsers, User::getId); }
}
