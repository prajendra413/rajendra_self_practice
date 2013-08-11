package com.cordys.example.domain.onetomanymanytoone.unidirection.onetomany.joincolumn;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Orders")

/**
 * One To Many Uni Directional association example.
 * @author prajendra
 *
 */
public class Order {
	
	@Id
	private int orderid;
	
	@Column(name = "OrderName")
	private String orderName;
	
	/*
	 * OneToMany : Defines association as one to many (Order to OrderDetails)
	 * JoinColumn annotations should be present current entity in case of OneToMany unidirectional association.
	 * Foreign key will be exists at the table of the target entity
	 */
	@OneToMany
	/*
	 * @JoinColumn :The name of the foreign key column. In this OneToMany unidirectional context join column is in table of target entity.
	 */
	@JoinColumn(name = "OrderId")
	private List<OrderDetail> orderDetails;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	} 

}
