package database.transactionmanagement.propagations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public void allProcessOnDB(long ID){
		update(ID);
		insert();
	}

}
