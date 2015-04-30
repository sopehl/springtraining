package aspectorientedprog.aopexample;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 29.04.2015.
 */
public class AspectStudentTest {

    @Test
    public void aspect_student_test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect/aspect-conf.xml");

        Student student = context.getBean("student", Student.class);
        student.setName("Semih Okan");

        student.printSomething();
        student.doSometing();

        student.getName();
    }

}
