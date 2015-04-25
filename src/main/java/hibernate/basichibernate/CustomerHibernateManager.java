package hibernate.basichibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by semih on 25.04.2015.
 */
//Veri tabanı işlemlerini bizlere service eden classtır
@Component("customerManager")
public class CustomerHibernateManager {

    @Autowired
    private CustomerRepositoryImp hibernateCustomerRepositoryImp;

    @Transactional
    public void save(Customer customer) {
        hibernateCustomerRepositoryImp.saveCustomer(customer);
    }

}
