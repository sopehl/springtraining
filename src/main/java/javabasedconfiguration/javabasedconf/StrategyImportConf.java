package javabasedconfiguration.javabasedconf;

import javabasedconfiguration.MulStrategy;
import javabasedconfiguration.Strategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by semih on 12.04.2015.
 */
// Bir configuration dosyası daha oluşturdum javabasedconfiguration paketindeki @Autowired ların içine aşağıdaki beanları enjekte etmeyi bekliyor
@Configuration
@ComponentScan("javabasedconfiguration")
public class StrategyImportConf {
    
    @Bean
    public Strategy getMull(){
        return new MulStrategy();
    }
}
