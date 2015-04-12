package javabasedconfiguration;

import javabasedconfiguration.javabasedconf.StrategyConf;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by semih on 12.04.2015.
 */
public class StrategyContextImportTest {

    @Test
    public void strategy_context_import(){
        ApplicationContext context = new AnnotationConfigApplicationContext(StrategyConf.class);

        StrategyContext strategy = context.getBean("strategy",StrategyContext.class);
        strategy.execute(2,5);
    }

}
