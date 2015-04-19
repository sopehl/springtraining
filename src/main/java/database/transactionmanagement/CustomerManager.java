package database.transactionmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by semih on 18.04.2015.
 */
@Component("manager")
//@Transactional class için gelirse o zaman classın tüm metodları @Transactional olucaktır
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
//    isolation şunu sağlamaktadır. bir thread bir veri üzeirnde çalışırken başka threadinde aynı veri üzeirnde çalışmasıyla
//    ortaya çıkabilecek sorunların önlenmesi
//    Nedir bu sorunlar A threadi bir veriyi değiştirdiğinde(daha commit etmedi), B threadininde henüz commit edilmemiş veriyi o aralıkta alıp
//    kullanması ile problemler çıkabilir. Ya A threadi o sırada veriyi rollback ettiyse B threadi yoluna yanlış veri ile devam eder.
//    Bu verinin okunlası olayına dirty read denir.
//    Aşağıdaki isolation = isolation.READ_UNCOMMITTED diyerek commit edilmemiş verileri o arada okuyabiliriz
//    Transactional metodlar mümkün mertebe READ_COMMITTED gibi çalışırlar. yani A threadi veri üzeirnde çalışırken sonradan
//    @Transactional annotasyonlu bir thread gelirse A threadinin işinin bitmesini bekleyecektir.

//    Ben burada basicdbforusing paketindeki bir database işlemleri ile bunu yaptım
//    2 tane @transactional metodla dene

//    dirty readten sonra bir diğer sorun ise şudur(nonrepeatable read): bir threadin ilk sorgusunda aldığı değerleri 2. veya 3. sordusunda alamamasıdır
//    aynı sorgunun değişik sonuçlar vermesi demek, başka bir thread iki sorgu arasına girmiş değşim yapmış, bunu önlemek için
//    @Transactional(isolation = Isolation.REPEATABLE_READ) şeklinde bi izolasyon kullanabiliriz. Bu şunu yapar ilk sql sorgularını korur ve onları kullanır
//    yani bu metod çalışırken dışarıdan db ye bir müdahale yapılsa bundan kendini korur sql sorguları ilk başta neyse onu kullanır
//    sonraki değişimlerden kendini korur, commit ile veride değişim yapılsa bile
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void diplaydep(long ID) {
        int i =0;
        while (true) {
            i++;
            System.out.println(transactionImp.getDepartmentByID(ID)+" "+i);
            try {
                Thread.sleep(5000);
                System.out.println(transactionImp.getDepartmentByID(ID)+" "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
