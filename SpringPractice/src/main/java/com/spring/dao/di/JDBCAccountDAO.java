package com.spring.dao.di;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import com.spring.domain.Account;


public class JDBCAccountDAO implements AccountDAO {

	private BasicDataSource basicDataSource;
	
	public void setBasicDataSource(BasicDataSource basicDataSource){
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
