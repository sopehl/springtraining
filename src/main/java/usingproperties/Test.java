package usingproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 24.03.2015.
 */
public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("property-conf.xml");

        OracleDatabaseImp oracle = context.getBean("database", OracleDatabaseImp.class);
        System.out.println(oracle.getPassword());
        System.out.println(oracle.getUser());
        System.out.println(oracle.getUrl());

    }

}
