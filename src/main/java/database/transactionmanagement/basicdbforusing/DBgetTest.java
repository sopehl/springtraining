package database.transactionmanagement.basicdbforusing;

import org.junit.Test;

import java.sql.*;

/**
 * Created by semih on 19.04.2015.
 */
public class DBgetTest {

    @Test
    public void test() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hr", "root", "");
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM jobs where job_id = 'IT_PROG'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                String str = res.getString("job_title");
                System.out.println(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
