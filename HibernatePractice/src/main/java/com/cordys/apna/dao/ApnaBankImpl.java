package com.cordys.apna.dao;

import com.cordys.apna.domain.Customer;
import com.cordys.apna.utils.JPAUtil;

public class ApnaBankImpl implements ApnaBankDAO {

	private static final String PERSISTENCE_UNIT_NAME = "JPA";
	@Override
	public void createCustomer(Customer customer) {
		JPAUtil jpaUtil = new JPAUtil(PERSISTENCE_UNIT_NAME);
		jpaUtil.beginTransaction();	
		jpaUtil.persist(customer);
		jpaUtil.commitTransaction();
		jpaUtil.shutDown();
	}
}
