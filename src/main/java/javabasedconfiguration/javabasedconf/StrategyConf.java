package javabasedconfiguration.javabasedconf;

import javabasedconfiguration.AddStrategy;
import javabasedconfiguration.Strategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by semih on 12.04.2015.
 */
// Springte bir configuration şekli olan java-based conf kullanılmıştır
// Springte bu classın bir configuration classı olduğunu aşağıdaki @Configuration annotasyonu belirlemektedir
@Configuration
// Aşağıdaki annotasyon ise şunu demektedir. Classın gövdesindeki beanları git buradaki paketlerde bulunan @Autowired lara enjekte et demektedir.
@ComponentScan("javabasedconfiguration")
// Alttaki annotasyon ise iki veya daha fazla configuration dosyasının birleştirilmesinden sorumlu
@Import(StrategyImportConf.class)
public class StrategyConf {

    // Aşağıdaki @Bean annotasyonu ile "enjekte edilecek" olan beanları tanımlamış bulunmaktayız. return işleminde hangi tip Strategy döndüreceğimizi belirledik.
    @Bean
    public Strategy getStrategy(){
        return new AddStrategy();
    }

}
