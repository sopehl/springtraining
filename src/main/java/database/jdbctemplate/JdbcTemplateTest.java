package database.jdbctemplate;

import database.datasource.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 16.04.2015.
 */
public class JdbcTemplateTest {

    @Test
    public void jdbc_temp_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("databaseconf/jdbc-temp-conf.xml");

        CustomerRepositoryImp customerRepositoryImp = context.getBean("customer",CustomerRepositoryImp.class);
        System.out.println(customerRepositoryImp.getCustomerByName("Okan").getLastName());

        Customer customer = new Customer("Bekir","Pehlivan","1234567");
        customerRepositoryImp.save(customer);

        System.out.println(customerRepositoryImp.getCustomerByNameForMap("Musa"));

        System.out.println(customerRepositoryImp.getAllCustomerByNameForList());
    }

}
