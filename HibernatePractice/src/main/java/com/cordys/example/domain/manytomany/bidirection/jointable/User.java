package com.cordys.example.domain.manytomany.bidirection.jointable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="User")
public class User {

	@Id
	@Column(name="UserId")
	private int userId;
	
	@Column(name="UserName")
	private String userName;
	
	@ManyToMany
	@JoinTable(
			name="User_Permission",
			joinColumns={
					@JoinColumn(name="User_Id")
			},
			inverseJoinColumns={
					@JoinColumn(name ="Permission_Id")
			},
			uniqueConstraints={
					@UniqueConstraint(
							columnNames = { "User_Id", "Permission_Id" }
					)
			}
	)
	private List<Permission> permissions = new ArrayList<>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}

