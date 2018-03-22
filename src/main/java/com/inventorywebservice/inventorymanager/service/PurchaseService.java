package com.inventorywebservice.inventorymanager.service;

import java.util.List;

import com.inventorywebservice.inventorymanager.model.PurchaseModel;

public interface PurchaseService {
	public List<PurchaseModel> findAllPurchasesByUser(String userEmail);
}
