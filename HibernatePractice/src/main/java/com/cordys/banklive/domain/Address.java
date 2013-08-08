package com.cordys.banklive.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name = "DoorNo", nullable = false)
	private String doorNo;
	
	@Column(name = "Street", nullable = false)
	private String street;
	
	@Column(name = "District", nullable = false)
	private String district;
	
	@Column(name = "State", nullable = false)
	private String state;
	
	@Column(name = "Country", nullable = false)
	private String country;
	
	@Column(name = "Pincode", nullable = false)
	private String pincode;
	
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
