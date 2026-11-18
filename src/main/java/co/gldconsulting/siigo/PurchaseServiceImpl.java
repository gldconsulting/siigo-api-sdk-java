package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Purchase;
import co.gldconsulting.siigo.model.PurchaseRequest;
import co.gldconsulting.siigo.model.PurchasesResponse;
import co.gldconsulting.siigo.resource.accounting.PurchaseResource;
import co.gldconsulting.siigo.service.accounting.PurchaseService;
import co.gldconsulting.siigo.service.accounting.PurchasesFilter;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseResource resource;
    PurchaseServiceImpl(PurchaseResource resource) { this.resource = resource; }
    @Override public PurchasesResponse getPurchases(PurchasesFilter filter) { return resource.getPurchases(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public Purchase getPurchase(String id) { return resource.getPurchase(Preconditions.id(id)); }
    @Override public Purchase createPurchase(PurchaseRequest request) { return resource.createPurchase(Objects.requireNonNull(request, "request")); }
    @Override public Purchase updatePurchase(String id, PurchaseRequest request) { return resource.updatePurchase(Preconditions.id(id), Objects.requireNonNull(request, "request")); }
    @Override public DeleteResponse deletePurchase(String id) { return resource.deletePurchase(Preconditions.id(id)); }
    @Override public List<Purchase> getAllPurchases(PurchasesFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getPurchases, Purchase::getId); }
    @Override public List<Purchase> getPurchasesByDate(LocalDate from, LocalDate to, PurchasesFilter filter) {
        Objects.requireNonNull(from, "from"); Objects.requireNonNull(to, "to");
        if (from.isAfter(to)) throw new IllegalArgumentException("from must be on or before to");
        return getAllPurchases(filter).stream().filter(p -> {
            if (p.getDate() == null) throw new IllegalStateException("A purchase has no document date");
            return !p.getDate().isBefore(from) && !p.getDate().isAfter(to);
        }).toList();
    }
}
