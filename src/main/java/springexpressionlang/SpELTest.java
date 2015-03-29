package springexpressionlang;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 29.03.2015.
 */
public class SpELTest {

    @Test
    public void expression_lang_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("expression-lang-config.xml");
        Customer customer = context.getBean("customer",Customer.class);

        System.out.println(customer.getValue());
        System.out.println(customer.getName());
        System.out.println(customer.isX());

        Employee employee = context.getBean("employee",Employee.class);
        System.out.println(employee.getName());
        System.out.println(employee.getNumber());
        System.out.println(employee.getProperty());
        System.out.println(employee.getOtherProperty());

        Employeer employeer = context.getBean("employeer",Employeer.class);
        System.out.println(employeer.getName());
    }

}
