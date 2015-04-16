package database.jdbctemplate.rowmapper;

import database.datasource.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 16.04.2015.
 */
public class RowMapperTest {

    @Test
    public void row_mapper_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("databaseconf/jdbc-temp-conf.xml");

        CustomerRepositoryImp customerRepositoryImp = context.getBean("customerRepo",CustomerRepositoryImp.class);
        Customer customer = customerRepositoryImp.getCustomerByName("Musa");
        System.out.println("id: "+ customer.getId());
    }

}
