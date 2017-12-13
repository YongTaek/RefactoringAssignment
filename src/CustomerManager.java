import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

    public List<Customer> customers = new ArrayList<Customer>() ;

    public Customer findCustomer(String customerName) {
        Customer foundCustomer = null ;
        for ( Customer customer: customers ) {
            if ( customer.getName().equals(customerName)) {
                foundCustomer = customer ;
                break ;
            }
        }
        return foundCustomer;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    void getCustomerList() {
        for ( Customer customer: getCustomers()) {

            // Extract method(getCustomerSummary) in CustomerManager Done
            customer.getCusomerSummary();
        }
    }

    public void addCustomer(String name) {
        customers.add(new Customer(name));
    }
}
