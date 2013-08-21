package com.spring.jpa.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.jpa.domain.onetoone.unidirection.joincolumn.Passport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:JpaTestContext.xml")
public class PassportDAOTest {
	
	@Autowired
	private IJPADao passportDao;
	
	private static Passport passport;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		passport = new Passport();
		passport.setPassportId(1);
		passport.setPassportNo("1234");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateEntity() {
		passportDao.createEntity(passport);
		
		// Assert
		Passport p = passportDao.findEntity(Passport.class, 1);
		assertEquals(1, p.getPassportId());
	}

}
