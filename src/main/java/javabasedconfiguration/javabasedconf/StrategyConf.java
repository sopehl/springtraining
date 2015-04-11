package javabasedconfiguration.javabasedconf;

import javabasedconfiguration.AddStrategy;
import javabasedconfiguration.Strategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by semih on 12.04.2015.
 */
@Configuration
@ComponentScan("javabasedconfiguration")
public class StrategyConf {

    @Bean
    public Strategy getStrategy(){
        return new AddStrategy();
    }

}
