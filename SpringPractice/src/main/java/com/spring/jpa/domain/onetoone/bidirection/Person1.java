package com.spring.jpa.domain.onetoone.bidirection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Person1")
public class Person1 {
	
	@Id
	private int personId;
	
	@Column(name = "Name")
	private String name;
	/*
	 * OneToOne : Defines a single-valued association to another entity that has
	 * one-to-one multiplicity
	 * If one-to-one association is bidirectional then mappedby attribute should be exists at non-owning side.
	 */
	@OneToOne 
	@JoinColumn(name= "PassId")
	private Passport1 passport;

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

	public Passport1 getPassport() {
		return passport;
	}

	public void setPassport(Passport1 passport) {
		this.passport = passport;
	}
	
}
