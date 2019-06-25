package com.siemens.tracker.backend.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class User implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	
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
	 * @return the username
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param username the username to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pwd
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param pwd the pwd to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



		@Override
	public String toString() {
		return "username [Username=" + username + ", Password=" + password + "]";
	}
	
}