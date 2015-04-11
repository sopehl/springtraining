package annotationconfigration;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 30.03.2015.
 */
public class StudentTest {

    @Test
    public void annotation_based_config_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("annotationconfig/annotation-based-config.xml");

        Student student = context.getBean("student", Student.class);
        student.aboutMessage();
        student.aboutLesson();
        System.out.println(student.getWebSite());
        System.out.println("user.name: " + student.getUserName());
    }
}
