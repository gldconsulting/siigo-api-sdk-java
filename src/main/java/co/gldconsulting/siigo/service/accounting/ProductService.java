package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Product;
import co.gldconsulting.siigo.model.ProductRequest;
import co.gldconsulting.siigo.model.ProductsResponse;
import java.util.List;

/** Siigo Product operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface ProductService {
    ProductsResponse getProducts(ProductsFilter filter);
    default ProductsResponse getProducts() { return getProducts(new ProductsFilter()); }
    Product getProduct(String id);
    Product createProduct(ProductRequest request);
    Product updateProduct(String id, ProductRequest request);
    DeleteResponse deleteProduct(String id);
    default List<Product> getAllProducts() { return getAllProducts(new ProductsFilter()); }
    List<Product> getAllProducts(ProductsFilter filter);
}
