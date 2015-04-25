package hibernate.basichibernate.hibernatetemplate;

import hibernate.basichibernate.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List find(long ID) {
        return hibernateTemplate.find("from Customer c where c.id=?",ID);
    }

//    isime göre arayıp verileri bir liste halinde geri döndürüyor
    public List findByName(String name) {
        return hibernateTemplate.find("from Customer c where c.name=?", name);
    }



}
