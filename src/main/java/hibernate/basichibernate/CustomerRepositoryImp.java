package hibernate.basichibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 25.04.2015.
 */
//Bu classta hibernate sessionFactory kullnılarak bazı veri tabanı işlemleri yapıldı
@Component("hibernateCustomer")
public class CustomerRepositoryImp {

//    Hibernate, sessionFactory nesnesine ihtiyaç dumaktadır.
    @Autowired
    private SessionFactory sessionFactory;

//    Customerin isimini verip objenin kendisini çeker
    public Customer getCustomerByName(String name) {
        String queryString = "from Customer c where c.name=:name";
        Query query = getCurrentSession().createQuery(queryString);
        query.setString("name", name);
        return (Customer) query.uniqueResult();
    }

//    Veritabanına customer eklemeyi sağlamaktadır
    public void saveCustomer(Customer customer) {
        getCurrentSession().save(customer);
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
