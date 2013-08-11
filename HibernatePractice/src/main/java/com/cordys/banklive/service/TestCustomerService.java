package com.cordys.banklive.service;

import java.util.ArrayList;
import java.util.List;

import com.cordys.banklive.utils.JPAUtil;
import com.cordys.example.domain.onetomanymanytoone.unidirection.onetomany.joincolumn.Order;
import com.cordys.example.domain.onetomanymanytoone.unidirection.onetomany.joincolumn.OrderDetail;

public class TestCustomerService {
	
public static void main(String[] args) {
	
	/*Calendar cal = Calendar.getInstance();
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
	
	Account account = new Account();
	account.setAccountNo("abc");
	account.setUserId("asd");
	account.setBranchCode("abc");
	account.setPassword("adef");
	account.setAmount("90");
	
	customer.setAccount(account);
	account.setCustomer(customer);
	
	
	JPAUtil jpaUtil = new JPAUtil();
	jpaUtil.beginTransaction();	
	
	jpaUtil.persist(customer);
	jpaUtil.persist(account);
	jpaUtil.commitTransaction();*/
	
	// OnetoMany unidirectional association
	List<OrderDetail> orderDetails = new ArrayList<>();
	Order order = new Order();
	order.setOrderid(1);
	order.setOrderName("first");
	
	OrderDetail ord = new OrderDetail();
	ord.setAmount(12);
	ord.setOrderDetailId(10);
	
	
	orderDetails.add(ord);
	order.setOrderDetails(orderDetails);	
	JPAUtil jpaUtil = new JPAUtil();
	jpaUtil.beginTransaction();	
	
	jpaUtil.persist(order);
	//ord.setOrderId(order.getOrderid());
	jpaUtil.persist(ord);
	jpaUtil.commitTransaction();
	
	jpaUtil = new JPAUtil();
	jpaUtil.beginTransaction();	
	Order o = (Order)jpaUtil.find(Order.class, 1);
	System.out.println(o.getOrderDetails().get(0).getOrderDetailId());
	jpaUtil.commitTransaction();
	
	// ManyToOne uni directional association
	
	/*Parent p = new Parent();
	p.setParentId(1);
	p.setName("abc");
	
	Child c = new Child();
	c.setChildId(10);
	c.setAmount(89);
	c.setParent(p);
	
	JPAUtil jpaUtil = new JPAUtil();
	jpaUtil.beginTransaction();	
	jpaUtil.persist(p);
	jpaUtil.persist(c);
	jpaUtil.commitTransaction();*/
	
	
}

}
