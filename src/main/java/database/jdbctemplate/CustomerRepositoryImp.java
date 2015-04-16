package database.jdbctemplate;

import database.datasource.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 16.04.2015.
 */
@Component("customer")
public class CustomerRepositoryImp {

//    jdbcTemplate burada bizim için jdbcnin kod karmaşıklık yükünü üzerimizden alıyor
//    Connection, PreperedStatement, ResultSet veya transaction gibi işlemlerin yönetimini kolaylaştırıyor
//    burada gerekli bağımlılığı springin bean containerından sağlıyorum
    @Autowired
    JdbcTemplate jdbcTemplate;

//    aşağıdaki metod -> parametre olarak aldığı ismin customerini getiriyor
//    datasource paketind
    public Customer getCustomerByName(String name){
        ResultSetExtractor<Customer> customerResultSetExtractor = new CustomerExtractor();

        String sql = "Select * from customer where firstName =?";
        return jdbcTemplate.query(sql,customerResultSetExtractor,name);
    }

}
