package database.jdbctemplate;

import database.datasource.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by semih on 16.04.2015.
 */
public class CustomerExtractor implements ResultSetExtractor {

//    Aşağıda şunu yapıyoruz Resultset sayesinde edindiğimiz bilgiler ile bir customerin map edilmesini sağğlıyoruz
    @Override
    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
        Customer customer = null;

        if(rs.next()){
            String firstName= rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String number = rs.getString("number");
            customer = new Customer(firstName,lastName,number);
            customer.setId(rs.getLong("id"));
        }
        return customer;
    }
}
