package database.jdbctemplate.rowmapper;

import database.datasource.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by semih on 16.04.2015.
 */
public class CustomerMapper implements RowMapper<Customer>{

    private Customer customer = null;

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        customer = new Customer();
        customer.setName(rs.getString("firstname"));
        customer.setLastName(rs.getString("lastName"));
        customer.setPhoneNum(rs.getString("number"));
        customer.setId(rs.getLong("id"));

        if(customer == null)
            throw new EmptyResultDataAccessException(1);

        return customer;
    }
}
