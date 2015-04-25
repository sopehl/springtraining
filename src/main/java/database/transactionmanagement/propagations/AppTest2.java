package database.transactionmanagement.propagations;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 25.04.2015.
 */
public class AppTest2 {

    @Test
    public void proxy_test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("databaseconf/transaction-conf.xml");

        DBManagerProxy dbManagerProxy = context.getBean("deneme", DBManagerProxy.class);
        dbManagerProxy.doIt(160);
    }

}
