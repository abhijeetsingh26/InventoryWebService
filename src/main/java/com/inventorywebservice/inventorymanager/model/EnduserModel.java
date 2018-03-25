package com.inventorywebservice.inventorymanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "endusers")
public class EnduserModel implements Serializable {

	private static final long serialVersionUID = -2878762391725649257L;
	@Column(name = "userUUID", unique = true, updatable = false, nullable = false)
	String userUUID;
	@Column(name = "user_email")
	@Id
	String userEmail;
	@Column(name = "user_fname")
	String userFirstName;
	@Column(name = "user_lname")
	String userLastName;
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	@Column(name = "createdAt")
	Date createdAt;
	@Column(name = "modifiedAt")
	Date modifiedAt;
	
	public String getuserUUID() {
		return userUUID;
	}
	public void setuserUUID(String userUUID) {
		this.userUUID = userUUID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	
}