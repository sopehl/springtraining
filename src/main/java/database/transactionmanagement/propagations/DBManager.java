package database.transactionmanagement.propagations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLDataException;

@Component("customerManager")
public class DBManager {

	@Autowired
	DatabaseImp databaseImp;

//    readOnly araştır.
    @Transactional(propagation = Propagation.REQUIRES_NEW , readOnly = true)
	public void operation(long id){
//		System.out.println(databaseImp.getDepartmentByID(id));
	    update(id);
    }

    @Transactional
    public void doIt(long ID) {
        operation(ID);
    }

    //@Transactional default değeri propagation = Propagation.REQUIRED dır
	@Transactional
	public void insert(){
		databaseImp.insertDept();
	}

    //Mevcut transaction ı durdur ve daha sonra yeni transaction oluştur oradan devam et demek anlamına gelmektedir.
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void update(long ID){
		databaseImp.updateDepartmentName(ID);
	}

//    Spring RuntimeException yada bunun alt sınıflarından bir istisna ile karşılaşırsa
//    db üzeirndeki tüm durumları iptal edip rollback yapmaktadır
//    rollbackFor için verilen exceptionda rollback yap anlamına gelmektedir.
//    noRollbackFor için verilen classta ise rollback yapma anlamında kullanılmaktadır
	@Transactional(rollbackFor = SQLDataException.class, noRollbackFor = ArrayIndexOutOfBoundsException.class)
	public void allProcessOnDB(long ID){
		update(ID);
		insert();
	}

}
