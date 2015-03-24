package factorymetod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by semih on 23.03.2015.
 */
public class Test {

    // bu kısıma daha sonra bakacağım.

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("factory-conf.xml");

        ShapeFactory shape = context.getBean("",ShapeFactory.class);





    }

}
