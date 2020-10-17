package Service.CustomerService;

import Model.Customer;

import java.util.Set;

public interface ISetCustomer {
    Customer inputCustomer();
    void infoCustomer(Customer customer);
    Set<Customer> inputCustomerSet();
    void infoCustomerSet(Set<Customer> customerSet);
}
