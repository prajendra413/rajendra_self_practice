package com.spring.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;

import com.spring.domain.Account;

public class CsvAccountDAO implements AccountDAO {

	private Resource csvResource;
	
	public CsvAccountDAO(Resource csvFile) {
		this.csvResource = csvFile;
    }
	/*public void setCsvResource(Resource csvFile) {
		this.csvResource = csvFile;
	}*/
	
	
	@Override
	public List<Account> findAccounts() {
	
		List<Account> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvResource.getFile()))) {
        	String line = null;
    		try {
    	        while((line= br.readLine()) != null) {
    	        	String fields[] = line.split(",");
    	        	accounts.add(new Account( Integer.parseInt(fields[0]), fields[1], Long.parseLong(fields[2])));
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
