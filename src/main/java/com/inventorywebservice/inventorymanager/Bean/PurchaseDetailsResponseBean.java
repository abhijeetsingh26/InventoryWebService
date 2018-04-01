package com.inventorywebservice.inventorymanager.Bean;

import java.util.Date;

public class PurchaseDetailsResponseBean {

	int purchaseSerial;
	String userUuid;
	String itemBarcode;
	String itemName;
	int itemPrice;
	/*int totalAmount = -1;
	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}*/

	Date createdAt;
	Date modifiedAt;

	public int getPurchaseSerial() {
		return purchaseSerial;
	}

	public void setPurchaseSerial(int purchaseSerial) {
		this.purchaseSerial = purchaseSerial;
	}

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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
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
