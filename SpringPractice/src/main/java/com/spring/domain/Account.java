package com.spring.domain;

public class Account 
{
	private String name;
	private int number;
	private long balance;
	
	public Account(String name, int number, long balance) {
		this.name = name;
		this.number = number;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public long getBalance() {
		return balance;
	}
	
	public void setBalance(long balance) {
		this.balance = balance;
	}

}
