package hibernate.basichibernate.hibernatetemplate;

import hibernate.basichibernate.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 25.04.2015.
 */
@Component("customerRepo")
public class CustomerRepositoryImp {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(Customer customer) {
        hibernateTemplate.save(customer);
    }



}
