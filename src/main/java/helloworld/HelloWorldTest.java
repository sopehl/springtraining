package helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by semih on 15.03.2015.
 */
public class HelloWorldTest {

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConf.class);

        MessageManager manager = context.getBean(MessageManager.class);
        manager.printMessage();

        MessageManager2 manager2 = context.getBean(MessageManager2.class);
        manager2.print();
    }

}
