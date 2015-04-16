package database.datasource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 13.04.2015.
 */
public class DataSourceTest {

    @Test
    public void data_source_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("databaseconf/datasources-conf.xml");

        CustomerRepositoryImp customerRepositoryImp = context.getBean("repo", CustomerRepositoryImp.class);
        Customer customer = customerRepositoryImp.getCustomerByName("Okan");
        System.out.println("id: "+customer.getId());
        System.out.println("Name: "+customer.getName());
        System.out.println("Lastname: "+customer.getLastName());
        System.out.println("PhoneNum: "+customer.getPhoneNum());

    }

}
