package com.spring.dao.di;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Account;

@Repository("jdbcAccountDAO")
public class JDBCAccountAnnotateDAO implements AccountAnnotateDAO {

	@Autowired
	private BasicDataSource basicDataSource;
	
	public void setBasicDataSource(BasicDataSource basicDataSource){
		this.basicDataSource = basicDataSource;
	}
	@Override
    public List<Account> findAccounts() {
	    List<Account> accounts = new ArrayList<>();
		try {
	      ResultSet rs =  basicDataSource.getConnection().createStatement().executeQuery("Select * from Account");
	    
	      while(rs.next()){
	    	  accounts.add(new Account(rs.getString("Name"), Integer.parseInt(rs.getString("No")), Long.parseLong(rs.getString("Balance"))));
	      }
	        
        } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		return accounts;
	}

}
