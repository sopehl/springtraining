package database.apachebasicdatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by semih on 18.04.2015.
 */
@Component("employees")
public class DBImplementation {

    public static final Logger logger = Logger.getLogger(DBImplementation.class.getName());

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List getJobsForList(){
        String sql = "SELECT * FROM jobs";

        logger.info("Fetched all employees");
        return jdbcTemplate.queryForList(sql);
    }

}
