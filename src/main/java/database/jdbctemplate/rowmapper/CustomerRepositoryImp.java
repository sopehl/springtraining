package database.jdbctemplate.rowmapper;

import database.datasource.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by semih on 16.04.2015.
 */
@Component("customerRepo")
public class CustomerRepositoryImp {

    private static final Logger logger = Logger.getLogger(CustomerRepositoryImp.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer getCustomerByName(String name){
        String sql = "SELECT * FROM CUSTOMER WHERE firstName = ?";
        logger.info("Fetch the customer named "+name);
        return jdbcTemplate.queryForObject(sql,new CustomerMapper(),name);
    }

    public List<Customer> getCustomerList(){
        String sql = "SELECT * FROM CUSTOMER";
        logger.info("Fetch the customer list");
        return jdbcTemplate.query(sql, new CustomerMapper());
    }
}
