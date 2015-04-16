package database.jdbctemplate;

import database.datasource.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by semih on 16.04.2015.
 */
@Component("customer")
public class CustomerRepositoryImp {
    public static final Logger logger = Logger.getLogger(CustomerRepositoryImp.class.getName());
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

//    Bu metod bir map döndürmektedir ve tek satırlı data seti için kullanılır
//    eğer birden fazla data seti dönerse, org.springframework.dao.IncorrectResultSizeDataAccessException: Incorrect result size: expected 1, actual 2
//    hatası vericektir
    public Map getCustomerByNameForMap(String name){
        String sql = "Select * from customer where firstName =?";
        logger.info("Customer is mapped");

        return jdbcTemplate.queryForMap(sql,name);
    }
//    queryForList ise birden fazla row döndüren queryler için kullanılabilir
    public List getAllCustomerByNameForList(){
        String sql = "SELECT * FROM CUSTOMER";

        return jdbcTemplate.queryForList(sql);
    }

    public void save(Customer customer){
        String sql = "insert into customer (firstName,lastName,number) values(?,?,?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getLastName(), customer.getPhoneNum());
        logger.info("Customer has been saved"+" named:"+customer.getName());
    }

}
