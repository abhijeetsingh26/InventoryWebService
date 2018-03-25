package com.inventorywebservice.inventorymanager.Bean;

public class PurchaseRequestBean {
	
	String userUUID;
	String itemBarCode;
	public String getUserUUID() {
		return userUUID;
	}
	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}
	public String getItemBarCode() {
		return itemBarCode;
	}
	public void setItemBarCode(String itemBarCode) {
		this.itemBarCode = itemBarCode;
	}

}
