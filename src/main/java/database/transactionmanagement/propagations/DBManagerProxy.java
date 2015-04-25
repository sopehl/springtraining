package database.transactionmanagement.propagations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by semih on 25.04.2015.
 */
@Component("deneme")
public class DBManagerProxy {

    @Autowired
    private DBManager dbManager;

//    Spring transaction işlemlerinde proxy-basedir. readOnly özelliğini çalıştıramamıştık,
//    bir tane proxy classı ekledikten sonra readOnly kullnımı ve @Transactional
//    nasıl kullanılır görmüş olduk
    @Transactional
    public void doIt(long ID) {
        dbManager.update(ID);
    }
}
