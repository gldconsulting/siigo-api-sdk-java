package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.Customer;
import co.gldconsulting.siigo.model.CustomerRequest;
import co.gldconsulting.siigo.model.CustomersResponse;
import co.gldconsulting.siigo.resource.accounting.CustomerResource;
import co.gldconsulting.siigo.service.accounting.CustomerService;
import co.gldconsulting.siigo.service.accounting.CustomersFilter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class CustomerServiceImpl implements CustomerService {
    private final CustomerResource resource;
    CustomerServiceImpl(CustomerResource resource) { this.resource = resource; }
    @Override public CustomersResponse getCustomers(CustomersFilter filter) { return resource.getCustomers(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public Customer getCustomer(String id) { return resource.getCustomer(Preconditions.id(id)); }
    @Override public Customer createCustomer(CustomerRequest request) { return resource.createCustomer(Objects.requireNonNull(request, "request")); }
    @Override public Customer updateCustomer(String id, CustomerRequest request) { return resource.updateCustomer(Preconditions.id(id), Objects.requireNonNull(request, "request")); }
    @Override public List<Customer> getAllCustomers(CustomersFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getCustomers, Customer::getId); }
}
