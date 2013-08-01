package com.spring.dao.di;

import java.util.List;

import com.spring.domain.Account;

public interface AccountAnnotateDAO {
	
	List<Account> findAccounts();
}
