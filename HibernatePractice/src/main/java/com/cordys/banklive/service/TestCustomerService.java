package com.cordys.banklive.service;

import java.util.Calendar;

import com.cordys.banklive.dao.BankLiveDAO;
import com.cordys.banklive.dao.BankLiveImplDAO;
import com.cordys.banklive.domain.Address;
import com.cordys.banklive.domain.Customer;

public class TestCustomerService {
	
public static void main(String[] args) {
	
	Calendar cal = Calendar.getInstance();
	cal.set(1986, 10, 05);
	Address customerAddress = new Address();
	
	customerAddress.setDoorNo("D-NO : 401");
	customerAddress.setStreet("New Balaji Nagar");
	customerAddress.setDistrict("Ranagareddy");
	customerAddress.setState("Andhra Pradesh");
	customerAddress.setCountry("India");
	customerAddress.setPincode("522261");
	
	Customer customer = new Customer();
	
	customer.setFirstName("Rajendra");
	customer.setMiddleName("Prasad");
	customer.setLastName("Potti");
	customer.setEmail("rajendraprasad.zampani@gmail.com");
	customer.setPanNo("AXOPP2161J");
	customer.setMobileNo("9642992726");
	customer.setGender("Male");
	customer.setNationality("Indian");
	customer.setReligion("hindu");
	customer.setOccupation("Salaried");
	customer.setBirthDate(cal.getTime());
	customer.setAddress(customerAddress);
	
	BankLiveDAO bankLiveDAO = new BankLiveImplDAO();
	
	bankLiveDAO.createEntity(customer);
}

}
