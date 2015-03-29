package importkullanimi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 29.03.2015.
 */
public class ImportTest {

    @Test
    public void import_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:import-keyword-config/import-config.xml");

        ServiceImp imp = context.getBean("service",ServiceImp.class);
        imp.showTheString();

    }

}
