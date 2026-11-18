package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Product;
import co.gldconsulting.siigo.model.ProductRequest;
import co.gldconsulting.siigo.model.ProductsResponse;
import co.gldconsulting.siigo.resource.accounting.ProductResource;
import co.gldconsulting.siigo.service.accounting.ProductService;
import co.gldconsulting.siigo.service.accounting.ProductsFilter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class ProductServiceImpl implements ProductService {
    private final ProductResource resource;
    ProductServiceImpl(ProductResource resource) { this.resource = resource; }
    @Override public ProductsResponse getProducts(ProductsFilter filter) { return resource.getProducts(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public Product getProduct(String id) { return resource.getProduct(Preconditions.id(id)); }
    @Override public Product createProduct(ProductRequest request) { return resource.createProduct(Objects.requireNonNull(request, "request")); }
    @Override public Product updateProduct(String id, ProductRequest request) { return resource.updateProduct(Preconditions.id(id), Objects.requireNonNull(request, "request")); }
    @Override public DeleteResponse deleteProduct(String id) { return resource.deleteProduct(Preconditions.id(id)); }
    @Override public List<Product> getAllProducts(ProductsFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getProducts, Product::getId); }
}
