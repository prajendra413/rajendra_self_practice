package com.spring.jpa.domain.manytomany.bidirection.jointable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Permission")
public class Permission {

	@Id
	@Column(name="PermissionId")
	private int permissionId;
	
	@Column(name="PermissionName")
	private String permissionName;

	@ManyToMany(mappedBy = "permissions")
	private List<User> users = new ArrayList<>();
	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
