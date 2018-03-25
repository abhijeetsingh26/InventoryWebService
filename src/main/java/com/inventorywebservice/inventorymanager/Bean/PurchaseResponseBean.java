package com.inventorywebservice.inventorymanager.Bean;

public class PurchaseResponseBean {
	String itemName;
	
	String message;
	
	int purchaseSerial;
	
	public int getPurchaseSerial() {
		return purchaseSerial;
	}

	public void setPurchaseSerial(int purchaseSerial) {
		this.purchaseSerial = purchaseSerial;
	}

	Boolean isPurchaseSuccessfull;

	public Boolean getIsPurchaseSuccessfull() {
		return isPurchaseSuccessfull;
	}

	public void setIsPurchaseSuccessfull(Boolean isPurchaseSuccessfull) {
		this.isPurchaseSuccessfull = isPurchaseSuccessfull;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
