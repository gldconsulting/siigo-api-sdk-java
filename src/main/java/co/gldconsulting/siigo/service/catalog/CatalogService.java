package co.gldconsulting.siigo.service.catalog;

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
import java.util.List;

/** Siigo Catalog operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface CatalogService {
    List<Tax> getTaxes();
    List<MiscIncome> getMiscIncomes();
    List<Expense> getExpenses();
    List<Warehouse> getWarehouses();
    List<CostCenter> getCostCenters();
    List<PriceList> getPriceLists();
    List<FixedAsset> getFixedAssets();
    List<DocumentType> getDocumentTypes(DocumentKind type);
    List<PaymentType> getPaymentTypes(DocumentKind documentType);
    UsersResponse getUsers(UsersFilter filter);
    default UsersResponse getUsers() { return getUsers(new UsersFilter()); }
    List<User> getAllUsers(UsersFilter filter);
}
