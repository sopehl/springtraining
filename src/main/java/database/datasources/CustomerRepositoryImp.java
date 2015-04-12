package database.datasources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by semih on 12.04.2015.
 */
// Burada bean isimlendirmesini yapmış olduk. XMLdeki id gibi düşünebilirsiniz. Xmldeki name içinde @Qualifier kullanılır
@Component("repo")
public class CustomerRepositoryImp {

    // Burada birtane datasource'a bağımlıyım.-Springin burada configuration dosyasından enjekte etmesini bekliyoruz
    // datasourcelar database hakkında bilgileri bizlere verir
    @Autowired
    private DataSource dataSource;

    // Aşağıdaki metod bir Customerin ismi ile elde edilmesini sağlar. Ama aynı isimde 2 kişi varsa sonuncuyu verir.
    // Ona göre implement edilmiştir. Liste kullanılarak kaybolan customerleride alabiliriz.
    // input olarak isim veriyorsun sana customer objesi veriyor ;)
    public Customer getCustomerByName(String name){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        Customer customer = null;
        try {
            con = dataSource.getConnection();
            pstmt = con.prepareStatement("SELECT * FROM customer WHERE firstName=?");
            pstmt.setString(1,name);
            res = pstmt.executeQuery();
            while (res.next()){
                customer = new Customer();
                customer.setId(res.getLong("id"));
                customer.setName(res.getString("firstName"));
                customer.setLastName(res.getString("lastName"));
                customer.setPhoneNum(res.getString("number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(con != null)
                        con.close();
                    if(pstmt != null)
                        pstmt.close();
                    if(res != null)
                        res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return customer;
    }

}
