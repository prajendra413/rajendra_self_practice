package com.spring.jpa.domain.onetomanymanytoone.bidirection.jointable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "State")
public class State {

	@Id
	private int id;
	
	@Column(name = "StateName")
	private String name;
	
	@ManyToOne
	@JoinTable(
			name = "Country_State",
			joinColumns={
					@JoinColumn(
								name = "StateId", unique = true
							)
			},
			inverseJoinColumns={
					@JoinColumn(
								name = "CounrtyId"
							)
			}
	)
	private Country country;
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
