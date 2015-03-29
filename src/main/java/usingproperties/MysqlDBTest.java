package usingproperties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by semih on 29.03.2015.
 */
public class MysqlDBTest {

    @org.junit.Test
    public void mysql_properties_example(){
        ApplicationContext context = new ClassPathXmlApplicationContext("properties/util-property.xml");

        MysqlDatabaseImp mysql = context.getBean("mysql",MysqlDatabaseImp.class);
        //properties özelliğine arka tarafta(xml dosyasında) atamaları yaptık ve buradan rahatça çekiyoruz.
        System.out.println(mysql.getProperties().getProperty("datasource.pwd"));
        System.out.println(mysql.getProperties().getProperty("datasource.url"));
        System.out.println(mysql.getProperties().getProperty("datasource.user"));


    }

}
