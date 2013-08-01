package com.spring.dao.di;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.spring.domain.Account;

@Repository("csvAccountDAO")
public class CsvAccountAnnotateDAO implements AccountAnnotateDAO {

	private Resource csvResource;

	public void setCsvResource(Resource csvFile) {
		this.csvResource = csvFile;
	}
	
	@Override
	public List<Account> findAccounts() {
	
		List<Account> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvResource.getFile()))) {
        	String line = null;
    		try {
    	        while((line= br.readLine()) != null) {
    	        	String fields[] = line.split(",");
    	        	accounts.add(new Account(fields[0], Integer.parseInt(fields[1]), Long.parseLong(fields[2])));
    	        }
            }
    		catch (IOException e) {
    	        // TODO Auto-generated catch block
    	        e.printStackTrace();
            }
        } catch (IOException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
        } 
		
		return accounts;
	}
}
