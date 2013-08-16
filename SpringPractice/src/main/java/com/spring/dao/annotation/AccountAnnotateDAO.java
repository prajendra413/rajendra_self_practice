package com.spring.dao.annotation;

import java.util.List;

import com.spring.domain.Account;

public interface AccountAnnotateDAO {
	
	List<Account> findAccounts();
}
