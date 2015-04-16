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
/*
* Spring terminolojisinde, veri tabanı satırlarını bir objeye map eden classlara callbask classı denilmektedir. Buradaki
* CustomerMapper classı bir callbak classıdır. jdbctemplate paketinde bu işlemi Extractor classı ile yaptım
* aynı map etme işlemini burada bir başka sınıf olan RowMapper sınıfını implemente ederek yapmaktayım
* */
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
