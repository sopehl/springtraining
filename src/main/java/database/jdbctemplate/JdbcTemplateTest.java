package database.jdbctemplate;

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
    }

}
