package metodenjeksiyon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 16.03.2015.
 */
public class MetodEnjTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");

        Singleton sing = context.getBean("singleton",Singleton.class);
        sing.doSomething();

        Singleton sing2 = context.getBean("singleton",Singleton.class);
        sing2.doSomething();
    }

}
