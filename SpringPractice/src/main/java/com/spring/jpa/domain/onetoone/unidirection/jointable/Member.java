package com.spring.jpa.domain.onetoone.unidirection.jointable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Member_FK")
public class Member {
	@Id
	@Column(name="Member_Id")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@OneToOne
	/*
	 * It is specified owning side of association (foreing key table).
	 */
	@JoinTable
	(	name = "MemerFK_PeoplePK",
		/*
		 * Specifies the foreign key columns in joint table which references the primary table of entity owning association.  
		 */
	 	joinColumns={
			/*
			 * referencedColumnName : The name of the column referenced by this foreign key column
			 */
			@JoinColumn(name = "MemberId", referencedColumnName = "Member_Id")
		},
		/*
		 * Specifies the foreign key columns in joint table which references the primary table of entity that does not owning association( inverse side of association).
		 */
		inverseJoinColumns={
			/*
			 * referencedColumnName : The name of the column referenced by this foreign key column
			 */
			@JoinColumn(name = "PersonId", referencedColumnName = "People_Id", unique = true)
		}
	)
	private People people;

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

	public People getPeople() {
		return people;
	}

	public void setPeople(People person) {
		this.people = person;
	}
	
	
}
