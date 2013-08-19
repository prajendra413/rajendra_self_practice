package com.spring.jpa.service;

import com.spring.jpa.domain.onetoone.unidirection.joincolumn.Passport;

public interface IJPAService {
	
	void createPassport(Passport p);
	
	void updatePassport(Passport p);
	
	void deletePassport(Passport p);
	
	Passport findPassport(int id);
	
	void update(int id, String value);
 
}