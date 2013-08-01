package com.spring.service.di;

import java.util.List;

import com.spring.dao.di.AccountDAO;
import com.spring.domain.Account;

public class AccountService {
	
	private AccountDAO accountDAO;

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
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
