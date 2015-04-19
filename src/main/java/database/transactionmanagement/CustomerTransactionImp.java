package database.transactionmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by semih on 18.04.2015.
 */
@Component("trans")
public class CustomerTransactionImp extends JdbcDaoSupport{

    public static final Logger logger = Logger.getLogger(CustomerTransactionImp.class.getName());

    @Autowired
    public CustomerTransactionImp(DataSource dataSource) {
        setDataSource(dataSource);
    }

//    @Transactional annotasyonu buralara gelmemektedir. Buraya ekleyerek hata yaptım
    public void deleteCustomerByName(String name){
        String sql = "DELETE FROM departments WHERE department_name = ?";

        logger.info("Deleted customer named: "+ name);
        getJdbcTemplate().update(sql,name);
    }

    public void deleteCustomerByID(Long ID) {
        String sql = "DELETE FROM departments WHERE department_id = ?";

        logger.info("Deleted customer named: "+ ID);
        getJdbcTemplate().update(sql, ID);
    }

    public Map getDepartmentByID(long ID){
        String sql = "Select * from departments where department_id=?";
        return getJdbcTemplate().queryForMap(sql,ID);
    }

    public List getAllCustomer(){
        String sql = "Select * FROM customer";

        return getJdbcTemplate().queryForList(sql);
    }

    public void displayAllCustomer() {
        for (Object o : getAllCustomer()) {
            System.out.println(o);
        }
    }

}
