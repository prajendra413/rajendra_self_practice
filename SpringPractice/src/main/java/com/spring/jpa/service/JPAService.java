package com.spring.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.dao.IJPADao;
import com.spring.jpa.domain.onetoone.unidirection.joincolumn.Passport;

@Service(value = "jpaService")

public class JPAService implements IJPAService{

	@Autowired
	@Qualifier(value="jpaDao")
	private IJPADao jpaDao;
	
	public IJPADao getJpaDao() {
		return jpaDao;
	}

	public void setJpaDao(IJPADao jpaDao) {
		this.jpaDao = jpaDao;
	}

	@Override
	@Transactional
	public void createPassport(Passport p) {
		jpaDao.createEntity(p);
	}

	@Override
	public void updatePassport(Passport p) {
		jpaDao.updateEntity(p);	
	}

	@Override
	public void deletePassport(Passport p) {
		jpaDao.deleteEntity(p);	
	}
}
