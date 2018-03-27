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
	@Column(name="userUuid")
	String userUuid;
	
	@Column(name="itemBarcode")
	String itemBarcode;
	
	@Column(name="createdAt")
	Date createdAt;
	
	@Column(name="modifiedAt")
	Date modifiedAt;


	public String getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	public String getItemBarcode() {
		return itemBarcode;
	}
	public void setItemBarcode(String itemBarcode) {
		this.itemBarcode = itemBarcode;
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
