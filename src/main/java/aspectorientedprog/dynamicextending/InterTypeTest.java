package aspectorientedprog.dynamicextending;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 01.05.2015.
 */
public class InterTypeTest {

    @Test
    public void inter_type_test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect/inter-type.xml");
//        triangle beanını cast ettik ve triangle classını dinamik olarak genişletmiş olduk.
        ShapeCalculation triangle = context.getBean("triangle" , ShapeCalculation.class);
        triangle.calculatePerimater();
    }

}
