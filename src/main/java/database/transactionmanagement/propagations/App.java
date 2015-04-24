package database.transactionmanagement.propagations;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    @Test
    public void propagation_test() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("databaseconf/transaction-conf.xml");
        DBManager manager = applicationContext.getBean("customerManager",DBManager.class);
        
        //manager.allProcessOnDB(160);
    }
}
