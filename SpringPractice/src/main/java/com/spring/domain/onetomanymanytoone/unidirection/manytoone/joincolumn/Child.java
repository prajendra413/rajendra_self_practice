package com.spring.domain.onetomanymanytoone.unidirection.manytoone.joincolumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Child")
public class Child {
	
	@Id
	@Column(name = "ChildId")
	private int childId;
	
	@Column(name = "Amount")
	private int amount;
	
	/*
	 * @ManyToOne : Defines association to other entity with many to one multiplicity.
	 * If it is bidirectional association mappedBy attribute should present at OnetoMany mapping.
	 * JoinColumn annotations should be present source entity (owning entity).
	 * Foreign key will be exists at the table of the source entity
 	 */
	@ManyToOne
	/*
	 * @JoinColumn :The name of the foreign key column. In this ManyToOne context join column is in table of source entity.
	 * Default name strategy: Name of the referenced entity + it's primary key.
	 */
	@JoinColumn(name = "ParentId")
	private Parent parent;
	
	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	public Parent getParent() {
		return parent;
	}

}
