package com.spring.jpa.domain.onetomanymanytoone.unidirection.manytoone.joincolumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Parent")
public class Parent {
	
	@Id
	private int parentId;
	
	@Column(name = "Name")
	private String name;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int orderid) {
		this.parentId = orderid;
	}

	public String getName() {
		return name;
	}

	public void setName(String orderName) {
		this.name = orderName;
	}

}
