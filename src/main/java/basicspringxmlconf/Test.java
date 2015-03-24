package basicspringxmlconf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 15.03.2015.
 */
public class Test {

    public static void main(String[] args) {

        //Spring bean sunucusu oluşturalım
        ApplicationContext context = new ClassPathXmlApplicationContext("springconf.xml");

        Context c = context.getBean("cont",Context.class);
        System.out.println(c.executeOperation(7,10));

        Context c1 = context.getBean("context/cont",Context.class);
        System.out.println(c1.executeOperation(3,4));

        System.out.println(c);// beanların scope değerleri singleton olduğundan hashcode değerleri aynıdır.(Aynı objelerdir)
        System.out.println(c1);


    }

}
