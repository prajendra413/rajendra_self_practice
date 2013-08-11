package com.cordys.example.service;

import com.cordys.banklive.utils.JPAUtil;
import com.cordys.example.domain.manytomany.bidirection.jointable.Permission;
import com.cordys.example.domain.manytomany.bidirection.jointable.User;

public class TestService {
	
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
		/*List<OrderDetail> orderDetails = new ArrayList<>();
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
		Order o = jpaUtil.find(Order.class, 1);
		System.out.println(o.getOrderDetails().get(0).getOrderDetailId());
		jpaUtil.commitTransaction();*/
		
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
		
		//OneToOne unidirectional association
	
		/*Person1 per = new Person1();
		per.setPersonId(1);
		per.setName("Raj");
		
		Passport1 passport =  new Passport1();
		passport.setPassportId(1);
		passport.setPassportNo("797979");
		
		per.setPassport(passport);
		JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();	
		jpaUtil.persist(per);
		jpaUtil.persist(passport);
		jpaUtil.commitTransaction();
		
		jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();	
		Passport1 o = jpaUtil.find(Passport1.class, 1);
		System.out.println(o.getPerson().getName());
		jpaUtil.commitTransaction();*/
	
		/*JPAUtil jpaUtil = new JPAUtil();
		Member member = new Member();
		member.setId(1);
		member.setName("rajendra");
		
		People people = new People();
		people.setId(1);
		people.setName("rajendra");
		member.setPeople(people);
		jpaUtil.beginTransaction();
		jpaUtil.persist(people);
		jpaUtil.persist(member);
		jpaUtil.commitTransaction();
		
		JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();
		Member member1 = jpaUtil.find(Member.class, 1);
		System.out.println(member1.getPeople().getName());
		jpaUtil.commitTransaction();*/
		
		// OneToMany bidirectional association
	
		/*JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();
		Department dept = new Department();
		dept.setId(1);
		dept.setDeptName("CSC");
		
		Employee emp = new Employee();
		emp.setEmployeeId(1);
		emp.setEmployeeName("Rajendra");
		emp.setDepartment(dept);
		dept.getStudents().add(std);
		jpaUtil.persist(dept);
		//jpaUtil.persist(std);
		jpaUtil.commitTransaction();
		
		jpaUtil.beginTransaction();
		Department dept1 = jpaUtil.find(Department.class, 1);
		jpaUtil.remove(dept1);
		jpaUtil.commitTransaction();*/
	
		// One to many uni directinal using jointable
		
		/*JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();
		Bus bus = new Bus();
		bus.setId(1);
		bus.setName("Tenali");
		
		Passenger passenger1 = new Passenger();
		passenger1.setId(1);
		passenger1.setName("raje");
		
		Passenger passenger2 = new Passenger();
		passenger2.setId(2);
		passenger2.setName("prasasd");
		
		bus.getPassengers().add(passenger1);
		bus.getPassengers().add(passenger2);
		jpaUtil.persist(passenger1);
		jpaUtil.persist(passenger2);
		jpaUtil.persist(bus);
		jpaUtil.commitTransaction();*/
	
		// Many to One uni directional using jointable
	
		/*Vehicle vehicle = new Vehicle();
		vehicle.setId(1);
		vehicle.setName("APSRTC");
		
		Rider rider1 = new Rider();
		rider1.setId(1);
		rider1.setName("Raje");
		rider1.setVehicle(vehicle);
		

		Rider rider2 = new Rider();
		rider2.setId(2);
		rider2.setName("Raje");
		rider2.setVehicle(vehicle);
		
		JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();
		jpaUtil.persist(vehicle);
		jpaUtil.persist(rider1);
		jpaUtil.persist(rider2);
		jpaUtil.commitTransaction();*/
	
		// One-to-Many / Many-to-One bidirectional using jointable
	
		/*Country country = new Country();
		country.setId(1);
		country.setName("India");
		
		State state1 = new State();
		state1.setId(1);
		state1.setName("Andhra Pradesh");
		
		State state2 = new State();
		state2.setId(2);
		state2.setName("Karnataka");
		
		state1.setCountry(country);
		state2.setCountry(country);
		
		country.getStates().add(state1);
		country.getStates().add(state2);
		
		JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();
		jpaUtil.persist(country);
		jpaUtil.persist(state1);
		jpaUtil.persist(state2);
		jpaUtil.commitTransaction();	

		JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();
		
		Country country = jpaUtil.find(Country.class, 1);
		for(State state : country.getStates()) {
			System.out.println(state.getName());
		}
		
		State state = jpaUtil.find(State.class, 1);
		System.out.println(state.getName()); */
	
		// ManyToMany unidirection using jointable
	
		/*JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();
		
		Course course1 = new Course();
		course1.setCourseId(1);
		course1.setCourseName("Java");
		
		Course course2 = new Course();
		course2.setCourseId(2);
		course2.setCourseName(".NET");
		
		Student student1  = new Student();
		student1.setStudentId(1);
		student1.setStudentName("Rajendra");

		Student student2 = new Student();
		student2.setStudentId(2);
		student2.setStudentName("Prasad");
		
		student1.getCourses().add(course1);
		student1.getCourses().add(course2);
		student2.getCourses().add(course1);
		student2.getCourses().add(course2);
		jpaUtil.persist(student1);
		jpaUtil.persist(student2);
		jpaUtil.persist(course1);
		jpaUtil.persist(course2);
		jpaUtil.commitTransaction();*/
	
		// ManyToMany bidirectional using jointable
	
		JPAUtil jpaUtil = new JPAUtil();
		jpaUtil.beginTransaction();
		
		Permission permission1 = new Permission();
		permission1.setPermissionId(1);
		permission1.setPermissionName("Regular");
		
		Permission permission2 = new Permission();
		permission2.setPermissionId(2);
		permission2.setPermissionName("Often");
		
		User user1 = new User();
		user1.setUserId(1);
		user1.setUserName("Raje");
		
		User user2 = new User();
		user2.setUserId(2);
		user2.setUserName("Prasad");
		
		user1.getPermissions().add(permission1);
		user1.getPermissions().add(permission2);
		

		user2.getPermissions().add(permission1);
		user2.getPermissions().add(permission2);
		
		permission1.getUsers().add(user1);
		permission1.getUsers().add(user2);
		
		permission2.getUsers().add(user1);
		permission2.getUsers().add(user2);
		
		jpaUtil.persist(user1);
		jpaUtil.persist(user2);
		jpaUtil.persist(permission1);
		jpaUtil.persist(permission2);
		
		jpaUtil.commitTransaction();
	}
}
