package com.cordys.banklive.domain;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/*
 * Entity : Persistence class
 * Attributes
 * 				name : To define Entity name, it can be used in JPQL
 */
@Entity	

/*
 * Table : Specifies primary key of the table for give entity
 * Attributes
 * 				name	 : Name of th table
 *				catalog	 : Catalog of the table
 * 				schema	 : Schema of the table.
 */
/*
 * Table name : 
 * Fist preference  : Table annotation name property value.
 * Second preference: Entity annotation name property value.
 * Third preference : Entity class name
 */
@Table (name = "Customer")
public class Customer {
	
	@Id
	@Column(name = "CustomerID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int customerId;
	
	@Column(name = "FirstName", nullable = false)
	private String firstName;
	
	/*
	 * Basic : It specifies the optional of the property at java level.
	 * Attributes
	 * 				optional : property  will be optional if it is true.
	 */
	@Basic(optional = false)
	@Column(name = "MiddleName")
	private String middleName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Transient
	private String name;
	
	@Column(name = "Email", nullable = false)
	private String email;
	
	@Column(name = "MobileNo", nullable = false)
	private String mobileNo;
	
	@Column(name = "PanNo")
	private String panNo;
	
	@Column(name = "BirthDate", nullable = false)
	private Date birthDate;
	
	@Column(name = "Gender", nullable = false)
	private String gender;
	
	@Column(name = "Occpation", nullable = false)
	private String occupation;
	
	@Column(name = "Regligion", nullable = false)
	private String religion;
	
	@Column(name = "Nationality", nullable = false)
	private String nationality;
	
	@Version
	@Column(name = "Opt_Lock_Version")
	private int version;
	
	@Embedded
	@AttributeOverrides( {
		@AttributeOverride(name = "street", column = @Column(name = "Customer_Street")),
		@AttributeOverride(name = "district", column = @Column(name = "Customer_District")),
		@AttributeOverride(name = "state", column = @Column(name = "Customer_State"))
	} )
	private Address address;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Account account;
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getPanNo() {
		return panNo;
	}
	
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getReligion() {
		return religion;
	}
	
	public void setReligion(String religion) {
		this.religion = religion;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getName() {
		return getFirstName() + getMiddleName();
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
}
