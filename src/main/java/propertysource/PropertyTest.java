package propertysource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by semih on 12.04.2015.
 */
public class PropertyTest {

    @Test
    public void property_test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConf.class);

        DatabaseContext dc = context.getBean("database",DatabaseContext.class);
        System.out.println(dc.getDatabase().getUrl());
    }

}
