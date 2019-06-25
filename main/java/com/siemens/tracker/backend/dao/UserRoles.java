package com.siemens.tracker.backend.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

	
	@Entity
	@Table(name="user_roles")
	public class UserRoles implements Serializable{
		
		private static final long serialVersionUID = 1L;
		@Id
		@Column(name="username")
		private String username; 
		
		@Column(name="role")
		private String role; 
		
		@Column(name="name")
		private String name;


	public UserRoles() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	}



	
	


