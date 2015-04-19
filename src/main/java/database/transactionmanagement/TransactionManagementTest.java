package database.transactionmanagement;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 18.04.2015.
 */
public class TransactionManagementTest {

    @Test
    public void trans_management_test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("databaseconf/transaction-conf.xml");

        CustomerManager customerTransactionImp = context.getBean("manager", CustomerManager.class);
        customerTransactionImp.operation("Administration", 110);
        customerTransactionImp.diplaydep(160);
    }

}
