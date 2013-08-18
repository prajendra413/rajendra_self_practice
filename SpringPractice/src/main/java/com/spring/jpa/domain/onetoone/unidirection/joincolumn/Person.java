package com.spring.jpa.domain.onetoone.unidirection.joincolumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Person is foreign key table and Passport is primary key table.
@Entity
@Table(name = "Person_FK")
public class Person {
	
	@Id
	private int personId;
	
	@Column(name = "Name")
	private String name;
	/*
	 * OneToOne : Defines a single-valued association to another entity that has
	 * one-to-one multiplicity
	 * If one-to-one association is bidirectional then mappedby attribute should be exists at non-owning side.
	 * If we use join for one-to-one then foreign key must present soure entity table
	 */
	@OneToOne 
	@JoinColumn(name= "PassId")
	private Passport passport;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
}
