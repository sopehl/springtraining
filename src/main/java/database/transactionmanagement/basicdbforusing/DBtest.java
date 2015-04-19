package database.transactionmanagement.basicdbforusing;

import org.junit.Test;

import java.sql.*;

/**
 * Created by semih on 19.04.2015.
 */
public class DBtest {

    @Test
    public void test() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hr" , "root" ,"");
            connection.setAutoCommit(false);
            String sql = "UPDATE departments set department_name='Deneme' WHERE department_id= 160";
//            PreparedStatement stmt = connection.prepareStatement(sql);
            Statement stmt = connection.createStatement();
            int ok = stmt.executeUpdate(sql);
            if (ok == 1) {
                System.out.println("inserting okay");
            }

            Thread.sleep(1);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
