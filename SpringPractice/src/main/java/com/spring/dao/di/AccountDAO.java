package com.spring.dao.di;

import java.util.List;

import com.spring.domain.Account;

public interface AccountDAO {
	
	List<Account> findAccounts();
}
