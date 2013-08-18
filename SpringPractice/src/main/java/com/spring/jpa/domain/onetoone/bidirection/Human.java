package com.spring.jpa.domain.onetoone.bidirection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Human")
public class Human {
	
	@Id
	private int humanID;
	
	@Column(name = "HumanName")
	private String name;
	/*
	 * OneToOne : Defines a single-valued association to another entity that has
	 * one-to-one multiplicity
	 * If one-to-one association is bidirectional then mappedby attribute should be exists at non-owning side.
	 */
	@OneToOne 
	@JoinColumn(name= "AadharId")
	private Aadhar aadhar;

	public int getHumanId() {
		return humanID;
	}

	public void setHumanId(int humanID) {
		this.humanID = humanID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	
}
