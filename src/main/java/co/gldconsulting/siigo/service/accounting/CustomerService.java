package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.Customer;
import co.gldconsulting.siigo.model.CustomerRequest;
import co.gldconsulting.siigo.model.CustomersResponse;
import java.util.List;

/** Siigo Customer operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface CustomerService {
    CustomersResponse getCustomers(CustomersFilter filter);
    default CustomersResponse getCustomers() { return getCustomers(new CustomersFilter()); }
    Customer getCustomer(String id);
    Customer createCustomer(CustomerRequest request);
    Customer updateCustomer(String id, CustomerRequest request);
    default List<Customer> getAllCustomers() { return getAllCustomers(new CustomersFilter()); }
    List<Customer> getAllCustomers(CustomersFilter filter);
}
