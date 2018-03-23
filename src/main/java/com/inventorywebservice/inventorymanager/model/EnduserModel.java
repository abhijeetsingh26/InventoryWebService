package com.inventorywebservice.inventorymanager.model;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Table(name="endusers")

public class EnduserModel implements Serializable {
	
	private static final long serialVersionUID = -2878762391725649257L;
	@Column
	String user_uuid;
	@Column
	String user_email;
	@Column
	Date createdAt;
	@Column
	Date modifiedAt;
	public String getUser_uuid() {
		return user_uuid;
	}
	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
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