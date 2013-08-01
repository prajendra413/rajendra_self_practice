package com.spring.service.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.dao.di.AccountAnnotateDAO;
import com.spring.domain.Account;

@Service("accountService")
public class AccountAnnotateService {
	
	// We can define autowired annonation at setter method level also
	
	@Autowired()
	@Qualifier("jdbcAccountDAO")
	private AccountAnnotateDAO accountDAO;

	public AccountAnnotateDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountAnnotateDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public long getAccountBalance(String accountName) {
		List<Account> accounts = getAccountDAO().findAccounts();
		for(Account account : accounts){
			if(accountName.equals(account.getName())){
				return account.getBalance();
			}
		}
		return 0;
	}
}
