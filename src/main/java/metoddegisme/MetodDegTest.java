package metoddegisme;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 16.03.2015.
 */
public class MetodDegTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-method-repl.xml");

        AClass aClass = context.getBean("aclass",AClass.class);
        aClass.doSomething("Hello", 10);
    }

}
