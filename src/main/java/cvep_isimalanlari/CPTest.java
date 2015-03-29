package cvep_isimalanlari;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 29.03.2015.
 */
public class CPTest {

    @Test
    public void c_p_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("c-p-tag-config.xml");
        Personel personel = context.getBean("person" , Personel.class);
        System.out.println(personel.getString());

        Student student = context.getBean("student" , Student.class);
        System.out.println(student.getName());

    }

}
