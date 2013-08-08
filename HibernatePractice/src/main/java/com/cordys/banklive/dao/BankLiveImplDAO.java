package com.cordys.banklive.dao;

import com.cordys.banklive.utils.JPAUtil;

public class BankLiveImplDAO implements BankLiveDAO {

	@Override
	public <T> void createEntity(T t) {
		JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();	
		jpaUtil.persist(t);
		jpaUtil.commitTransaction();
	}
	
}
