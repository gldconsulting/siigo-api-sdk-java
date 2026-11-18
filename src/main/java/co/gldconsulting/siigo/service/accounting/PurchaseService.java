package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Purchase;
import co.gldconsulting.siigo.model.PurchaseRequest;
import co.gldconsulting.siigo.model.PurchasesResponse;
import java.time.LocalDate;
import java.util.List;

/** Siigo Purchase operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface PurchaseService {
    PurchasesResponse getPurchases(PurchasesFilter filter);
    default PurchasesResponse getPurchases() { return getPurchases(new PurchasesFilter()); }
    Purchase getPurchase(String id);
    Purchase createPurchase(PurchaseRequest request);
    Purchase updatePurchase(String id, PurchaseRequest request);
    DeleteResponse deletePurchase(String id);
    default List<Purchase> getAllPurchases() { return getAllPurchases(new PurchasesFilter()); }
    List<Purchase> getAllPurchases(PurchasesFilter filter);
    /** Local inclusive document-date filter; no unsupported remote date parameters are sent. */
    default List<Purchase> getPurchasesByDate(LocalDate from, LocalDate to) { return getPurchasesByDate(from, to, new PurchasesFilter()); }
    List<Purchase> getPurchasesByDate(LocalDate from, LocalDate to, PurchasesFilter filter);
}
