package com.cordys.apna.service;

import java.math.BigInteger;

import com.cordys.apna.dao.ApnaBankDAO;
import com.cordys.apna.dao.ApnaBankImpl;
import com.cordys.apna.domain.Customer;

public class TestCustomerService {
	
public static void main(String[] args) {
	
	Customer customer = new Customer();
	customer.setFirstName("Rajendra");
	customer.setMiddleName("Prasad");
	customer.setLastName("Potti");
	customer.setStreet("New Balaji Nagar");
	customer.setArea("Kukatpally");
	customer.setCity("Hyderabad");
	customer.setCountry("India");
	customer.setEmail("rajendraprasad.zampani@gmail.com");
	customer.setPanNo("AXOPP2161J");
	customer.setMobileNo(new BigInteger("9642992726"));
	
	ApnaBankDAO  apnaBankDAO = new ApnaBankImpl();
	apnaBankDAO.createCustomer(customer);
}

}
