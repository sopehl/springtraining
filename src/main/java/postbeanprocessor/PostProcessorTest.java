package postbeanprocessor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 24.03.2015.
 */
public class PostProcessorTest {

    @Test
    public void bean_post_processor_test(){
        // Springde yaşam döngüsü göz önüne alındığında nesnelerin oluşturulma fazında spring
        // BeanPostProcessor interfacesindeki before ile başlayan metodların implementasyonu sonra init sonrada after ile başlayan metodları çalıştırır.
        // BeanPostProcessor implementasyonu configrasyonlarda belirtilmelidir. configrasyon dosyası yüklendiğinde spring bunu bilmeli.
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-post-pro-config.xml");

        Personel personel = context.getBean("personel",Personel.class);

        System.out.println(personel.getName());

    }

}
