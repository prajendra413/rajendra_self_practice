package com.spring.dao.annotation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.spring.domain.Account;

@Repository("springJDBCAccountDAO")
public class SpringJDBCAccountAnnotateDAO implements AccountAnnotateDAO{

	@Autowired
	private DriverManagerDataSource basicDataSource;
	
	public void setBasicDataSource(DriverManagerDataSource basicDataSource){
		this.basicDataSource = basicDataSource;
	}
	@Override
    public List<Account> findAccounts() {
	    List<Account> accounts = new ArrayList<>();
		try {
	      ResultSet rs =  basicDataSource.getConnection().createStatement().executeQuery("Select * from account");
	    
	      while(rs.next()){
	    	  accounts.add(new Account(Integer.parseInt(rs.getString("ID")), rs.getString("Name"), Long.parseLong(rs.getString("Balance"))));
	      }
	        
        } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		return accounts;
	}

}
