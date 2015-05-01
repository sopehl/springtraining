package aspectorientedprog.aopexample;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 01.05.2015.
 */
public class OrderAnnoatationTest {

    @Test
    public void order_annotation_test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect/aspect-conf.xml");
        Student student = context.getBean("student", Student.class);
        student.joinPointForOrder();
    }

}
