package postconstruct;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 25.03.2015.
 */
public class PostConstTest {

    @Test
    public void post_construct_test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("post-construct-config.xml");
    }

}
