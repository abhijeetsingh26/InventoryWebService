package com.inventorywebservice.inventorymanager.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="items_purchased")
public class PurchaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "purchase_serial", unique = true, updatable = false, nullable = false)
	int purchaseSerial;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchase_serial", unique = true, nullable = false, updatable = false)
	public int getPurchaseSerial() {
		return purchaseSerial;
	}
	public void setPurchaseSerial(int purchaseSerial) {
		this.purchaseSerial = purchaseSerial;
	}
	@Column(name="user_uuid")
	String user_uuid;
	
	@Column(name="item_barcode")
	String item_barcode;
	
	@Column(name="createdAt")
	Date createdAt;
	
	@Column(name="modifiedAt")
	Date modifiedAt;
	
	public String getUser_uuid() {
		return user_uuid;
	}
	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}
	public String getItem_barcode() {
		return item_barcode;
	}
	public void setItem_barcode(String item_barcode) {
		this.item_barcode = item_barcode;
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
