package com.cordys.example.domain.onetomanymanytoone.unidirection.manytoone.jointable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Rider")

public class Rider {
	
	@Id
	@Column(name = "RiderId")
	private int id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinTable(
			name = "Vehicle_Rider",
			joinColumns={
				@JoinColumn(name = "Rider_ID", unique = true)
			},
			inverseJoinColumns={
					@JoinColumn(name = "Vehicle_ID")
			}
	)

	private Vehicle vehicle;
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
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
