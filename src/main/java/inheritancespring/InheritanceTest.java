package inheritancespring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 29.03.2015.
 */
public class InheritanceTest {

    @Test
    public void inheritance_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("inheritance-car-config.xml");

        Car car = context.getBean("clio",Car.class);

        System.out.println("Brand:"+car.getBrand());
        System.out.println("TYPE:"+car.getCarType());
        System.out.println("Model:"+car.getModel());

        Car car2 = context.getBean("car",Car.class);
        System.out.println("//--------------------------------------------------------------------//");

        //Bu bean parent olarak kullandığımız bean ama bu beanı kullandığımızda brand ve model değerleri null gelmektedir.
        //Bu şekilde car beanını bir anlam ifade etmemektedir.
        //Programcının bu beanın kullanımını kaldırası gerekmektedir.
        //Kaldırma işlemini configrasyon dosyasında bu beanı abstract yaparak sağlar.

        System.out.println("Brand:"+car2.getBrand());
        System.out.println("TYPE:"+car2.getCarType());
        System.out.println("Model:"+car2.getModel());

        //Bu beandan bir örnek oluşturmaya kalktığımda org.springframework.beans.factory.BeanIsAbstractException: Error creating bean with name 'car': Bean definition is abstract
        //yukarıdaki exception gelmektedir
    }

}
