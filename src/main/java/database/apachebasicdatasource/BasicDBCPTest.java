package database.apachebasicdatasource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by semih on 18.04.2015.
 */
public class BasicDBCPTest {

    @Test
    public void basic_datasource_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("databaseconf/basicdatasource.xml");

        DBImplementation dbImplementation = context.getBean("employees", DBImplementation.class);
        List list = dbImplementation.getJobsForList();

        for (Object str : list) {
            System.out.println(str);
        }
    }

}
