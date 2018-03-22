package com.inventorywebservice.inventorymanager.model;


import java.io.Serializable;
import org.hibernate.annotations.Entity;
@Entity
public class PurchaseModel implements Serializable {
	
	String user_uuid;
	String user_email;
	
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

}
