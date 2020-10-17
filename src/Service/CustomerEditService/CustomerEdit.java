package Service.CustomerEditService;

import Model.Customer;

import java.util.Set;

public interface CustomerEdit {
    Set<Customer> editCustomerSet(Set<Customer> customerSet);
    void deleteCustomer(Set<Customer> customerSet);
}
