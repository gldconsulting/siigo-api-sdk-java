package co.gldconsulting.siigo.resource.catalog;

import co.gldconsulting.siigo.model.CostCenter;
import co.gldconsulting.siigo.model.DocumentKind;
import co.gldconsulting.siigo.model.DocumentType;
import co.gldconsulting.siigo.model.Expense;
import co.gldconsulting.siigo.model.FixedAsset;
import co.gldconsulting.siigo.model.MiscIncome;
import co.gldconsulting.siigo.model.PaymentType;
import co.gldconsulting.siigo.model.PriceList;
import co.gldconsulting.siigo.model.Tax;
import co.gldconsulting.siigo.model.UsersResponse;
import co.gldconsulting.siigo.model.Warehouse;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface CatalogResource {
    @GET("v1/taxes")
    List<Tax> getTaxes();
    @GET("v1/misc-incomes")
    List<MiscIncome> getMiscIncomes();
    @GET("v1/expenses")
    List<Expense> getExpenses();
    @GET("v1/warehouses")
    List<Warehouse> getWarehouses();
    @GET("v1/cost-centers")
    List<CostCenter> getCostCenters();
    @GET("v1/price-lists")
    List<PriceList> getPriceLists();
    @GET("v1/fixed-assets")
    List<FixedAsset> getFixedAssets();
    @GET("v1/document-types")
    List<DocumentType> getDocumentTypes(@Query("type") DocumentKind type);
    @GET("v1/payment-types")
    List<PaymentType> getPaymentTypes(@Query("document_type") DocumentKind documentType);
    @GET("v1/users")
    UsersResponse getUsers(@QueryMap Map<String, String> query);
}
