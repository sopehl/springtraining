package database.transactionmanagement.propagations;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component("database")
public class DatabaseImp extends JdbcDaoSupport{
	
	@Autowired
	public DatabaseImp(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	public List getDepartmentByID(long ID){
		String sql = "Select * from departments where department_id=?";
		
		return getJdbcTemplate().queryForList(sql, ID);
	}
	
	public List getDepartmentByName(String name){
		String sql = "Select * from departments where department_name=?";
		
		return getJdbcTemplate().queryForList(sql, name);
	}
	
	public void updateDepartmentName(long ID){
		String sql = "Update departments set department_name= 'Deneme' where department_id=?";
		
		getJdbcTemplate().update(sql,ID);
	}

    //aşağıdaki sqlde bilerek sorun meydana getirdim ki transaktion bundan etkilensin diye
	public void insertDept(){
		String sql = "insert into departments values (1,'DepName',100,1700)";
		
		getJdbcTemplate().update(sql);
	}
}
