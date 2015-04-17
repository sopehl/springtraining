package database.jdbcdaosupport;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 17.04.2015.
 */
public class JDBCDaoSupportTest {

    @Test
    public void dao_sup_test(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("databaseconf/jdbc-temp-conf.xml");

        CustomerRepositoryImp customerRepositoryImp = context.getBean("customerDao",CustomerRepositoryImp.class);
        System.out.println(customerRepositoryImp.getCustomerByName("Musa").getId());
    }

}
