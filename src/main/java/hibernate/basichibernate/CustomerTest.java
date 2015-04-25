package hibernate.basichibernate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 25.04.2015.
 */
public class CustomerTest {

    @Test
    public void hibernate_test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("hibernate/hibernate-conf.xml");

        CustomerHibernateManager hiberCustomer = context.getBean("customerManager",
                CustomerHibernateManager.class);

        Customer customer = new Customer("Pehlivan", "Okan", 22);
        hiberCustomer.save(customer);
        System.out.println(hiberCustomer.getCustomerByName("Pehlivan"));
    }

}
