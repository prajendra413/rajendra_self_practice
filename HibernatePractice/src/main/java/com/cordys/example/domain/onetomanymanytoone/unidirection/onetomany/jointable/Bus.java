package com.cordys.example.domain.onetomanymanytoone.unidirection.onetomany.jointable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bus")
public class Bus {
	
	@Id
	@Column(name = "BusId")
	private int id;
	
	@Column
	private String name;
	
	@OneToMany
	@JoinTable(
			name = "Bus_Passenger",
			joinColumns={
				@JoinColumn(name = "Bus_Id")
			},
			inverseJoinColumns={
					@JoinColumn(name = "Passenger_Id", unique = true)
			}
	)
	private List<Passenger> passengers = new ArrayList<>();

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

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
}
