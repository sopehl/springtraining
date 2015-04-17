package database.jdbcdaosupport;

import database.datasource.Customer;
import database.jdbctemplate.CustomerExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by semih on 17.04.2015.
 */
@Component(value = "customerDao")
public class CustomerRepositoryImp extends JdbcDaoSupport {

    @Autowired
    public CustomerRepositoryImp(DataSource dataSource){
        setDataSource(dataSource);
    }

    public Customer getCustomerByName(String name){
        String sql = "SELECT * FROM CUSTOMER WHERE firstName=?";

        ResultSetExtractor<Customer> resultSetExtractor =
                new CustomerExtractor();
        return getJdbcTemplate().query(sql, resultSetExtractor, name);
    }

}
