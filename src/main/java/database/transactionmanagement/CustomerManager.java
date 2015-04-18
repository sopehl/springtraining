package database.transactionmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by semih on 18.04.2015.
 */
@Component("manager")
public class CustomerManager {

    @Autowired
    CustomerTransactionImp transactionImp;

//    @Transactional annotasyonu Service katmanında kullanılmaktadır. Görüldüğü gibi arka arkaya 2 tane db işlemi yapılan
//    metodlar kullanılmıştır. Bunlardan birtanesinde yapılacak hata diğerlerinin db üzerinde kalıcı işlem(commit)
//    yapmasını engelleyecektir. deleteCustomerByName metodunda sqlde yapılan bir hata sonucunda bu fark edilebilir.
    @Transactional
    public void operation(String name , long ID){
        transactionImp.deleteCustomerByID(ID);
        transactionImp.deleteCustomerByName(name);
    }

    public CustomerTransactionImp getTransactionImp() {
        return transactionImp;
    }

}
