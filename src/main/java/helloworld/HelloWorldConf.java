package helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by semih on 15.03.2015.
 */

@Configuration
@ComponentScan
public class HelloWorldConf {

    @Bean
    public HelloWorldService getMessageService(){
        return new HelloWorldImp();
    }

}
