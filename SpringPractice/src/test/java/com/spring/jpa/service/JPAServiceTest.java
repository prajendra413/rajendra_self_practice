package com.spring.jpa.service;

import static org.mockito.Mockito.mock;
import org.junit.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import com.spring.jpa.dao.IJPADao;
import com.spring.jpa.domain.onetoone.unidirection.joincolumn.Passport;

public class JPAServiceTest {
	
	@Test
	public void testCreatePassport() {
		JPAService jpaService = new JPAService();
		Passport p = new Passport();
		p.setPassportId(1);
		p.setPassportNo("123");
		
		IJPADao jpaDao = mock(IJPADao.class);
		
		Mockito.doNothing().when(jpaDao).createEntity(p);
		jpaService.setJpaDao(jpaDao);
	
		jpaService.createPassport(p);
	}
	
	@Test
	public void testUpdatePassport() {
		JPAService jpaService = new JPAService();
		Passport p = new Passport();
		p.setPassportId(1);
		p.setPassportNo("123");
		
		IJPADao jpaDao = mock(IJPADao.class);
		
		Mockito.doNothing().when(jpaDao).updateEntity(p);
		jpaService.setJpaDao(jpaDao);
	
		jpaService.updatePassport(p);
	}
	
	@Test
	public void testDeletePassport() {
		JPAService jpaService = new JPAService();
		Passport p = new Passport();
		p.setPassportId(1);
		p.setPassportNo("123");
		
		IJPADao jpaDao = mock(IJPADao.class);
		
		Mockito.doNothing().when(jpaDao).deleteEntity(p);
		jpaService.setJpaDao(jpaDao);
	
		jpaService.deletePassport(p);
	}
	
	@Test
	public void testFindPassport() {
		JPAService jpaService = new JPAService();
		Passport p = new Passport();
		p.setPassportId(1);
		p.setPassportNo("123");
		
		IJPADao jpaDao = mock(IJPADao.class);
		
		Mockito.when(jpaDao.findEntity(Passport.class, 1)).thenReturn(p);
		
		jpaService.setJpaDao(jpaDao);
	
		Passport p1 = jpaService.findPassport(1);
		
		//Assert
		Assert.assertEquals(1, p1.getPassportId());
	}

}
