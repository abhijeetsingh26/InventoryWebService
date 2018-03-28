package com.inventorywebservice.inventorymanager.service;

import java.util.List;

import com.inventorywebservice.inventorymanager.Bean.PurchaseDetailsResponseBean;
import com.inventorywebservice.inventorymanager.Bean.PurchaseRequestBean;
import com.inventorywebservice.inventorymanager.Bean.PurchaseResponseBean;

public interface PurchaseService {
	public List<PurchaseDetailsResponseBean> findAllPurchasesByUser(String userEmail);
	
	PurchaseResponseBean createNewPurchaseForUser(PurchaseRequestBean prb);
}
