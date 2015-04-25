package hibernate.basichibernate.hibernatetemplate;

import hibernate.basichibernate.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by semih on 25.04.2015.
 */
@Transactional
@Component("customerService")
public class CustomerRepositoryService {

    @Autowired
    private CustomerRepositoryImp customerRepositoryImp;

    public void saveCustomer(Customer customer) {
        customerRepositoryImp.save(customer);
    }

    public void findCustomer(long id) {
        System.out.println(customerRepositoryImp.find(id));
    }

    public void findCustomerByName(String name) {
        System.out.println(customerRepositoryImp.findByName(name));
    }

}
