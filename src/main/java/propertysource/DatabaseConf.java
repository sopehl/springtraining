package propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by semih on 12.04.2015.
 */
// Bu classın bir configuration dosyası olduğunu gösterir
@Configuration
// Enjekte edilecek olan bağımlılıkların bu paket içinde aranması gerektiğini söyler
@ComponentScan(basePackages = "propertysource")
// Burada biz properties dosyalarını ve yollarını gösteriyoruz
@PropertySource("classpath:properties/datasource.properties")
public class DatabaseConf{

    private @Value("${datasource.url}") String url;

    /*
    @Autowired
    Environment environment;
    */

    @Bean
    public Database getDatabase(){
        return new Database(url);
    }

    // PropertySourcesPlaceholderConfigurer burada ile calistirilan beandir ve görevi ise yukarıdaki ${datasource.url} e
    // veya varsa başka properties keylerine enjekte işlemini yapmaktadır.

    // Bu bean statik olmalıdır aksi halde static olmadığına dair exception vermekte. PropertySourcesPlaceholderConfigurer
    @Bean
    public static PropertySourcesPlaceholderConfigurer getEnvironment(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
