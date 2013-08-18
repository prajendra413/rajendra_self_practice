package com.spring.jpa.domain.onetoone.bidirection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Aadhar")
public class Aadhar {
	
	@Id
	private int aadharId;
	
	@Column(name = "AadharNo")
	private String aadharNo;

	@OneToOne(mappedBy = "aadhar")
	private Human people;
	
	public Human getPeople() {
		return people;
	}

	public void setPeople(Human people) {
		this.people = people;
	}

	public int getAadharId() {
		return aadharId;
	}

	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	

}
