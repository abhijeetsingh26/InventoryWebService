package com.inventorywebservice.inventorymanager.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Table(name="items_purchased")

public class PurchaseModel implements Serializable {
	
	private static final long serialVersionUID = 908432581538678241L;
	@Column
	String user_uuid;
	@Column
	String user_email;
	@Column
	String item_barcode;
	@Column
	String item_name;
	@Column
	int item_price;
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

}
