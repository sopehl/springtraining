package hibernate.basichibernate.hibernatetemplate;

import hibernate.basichibernate.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 25.04.2015.
 */
public class HibernateTemplateTest {

    @Test
    public void hibernate_template_test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("hibernate/hibernate-conf.xml");

        CustomerRepositoryService service = context.getBean("customerService", CustomerRepositoryService.class);
        Customer customer = new Customer("Pehlivan", "Okan", 12);
//        service.saveCustomer(customer);
//        service.findCustomer(1);
        service.findCustomerByName("Pehlivan");
    }

}
