package aspectorientedprog;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 26.04.2015.
 */
public class AdviceAndJoinPointTest {

    @Test
    public void advice_joinpoint_test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect/aspect-conf.xml");
        TargetClassForAspect aspect = context.getBean("aop", TargetClassForAspect.class);
        aspect.doSomething();
        System.out.println();

    }

}
