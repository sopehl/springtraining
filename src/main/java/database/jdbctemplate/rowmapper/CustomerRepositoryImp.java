package database.jdbctemplate.rowmapper;

import database.datasource.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by semih on 16.04.2015.
 */
@Component("customerRepo")
public class CustomerRepositoryImp {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer getCustomerByName(String name){
        String sql = "SELECT * FROM CUSTOMER WHERE firstName = ?";

        return jdbcTemplate.queryForObject(sql,new CustomerMapper(),name);
    }

}
