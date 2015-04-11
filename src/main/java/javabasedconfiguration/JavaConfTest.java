package javabasedconfiguration;

import javabasedconfiguration.javabasedconf.StrategyConf;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by semih on 12.04.2015.
 */
public class JavaConfTest {

    @Test
    public void java_conf_test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(StrategyConf.class);

        StrategyContext strategyContext = context.getBean("stra",StrategyContext.class);
        strategyContext.execute(1,2);
    }

}
