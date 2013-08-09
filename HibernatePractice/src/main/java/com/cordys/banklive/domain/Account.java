package com.cordys.banklive.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Account")
public class Account {
	
	@org.hibernate.annotations.GenericGenerator
	(
			name = "myForeignGenerator", 
			strategy = "foreign", 
			parameters = @Parameter
			(
					name = "property",
					value = "customer"
			)
	)
	@Id @GeneratedValue(generator = "myForeignGenerator")
	private int accountId;
	
	@Column(name = "AccountNo", nullable = false, unique = true)
	private String accountNo;
	
	@Column(name = "UserId", nullable = false, unique = true)
	private String userId;
	
	@Column(name = "Password", nullable = false, unique = true)
	private String password;
	
	@Column(name = "BranchCode", nullable = false)
	private String branchCode;
	
	@Column(name = "Amount", nullable = false)
	private String amount;
	
	@OneToOne
	private Customer customer;
	
	public Customer getCustomer()
	{
		return this.customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	

}
