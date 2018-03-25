package com.inventorywebservice.inventorymanager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorywebservice.inventorymanager.Bean.PurchaseRequestBean;
import com.inventorywebservice.inventorymanager.Bean.PurchaseResponseBean;
import com.inventorywebservice.inventorymanager.model.PurchaseModel;
import com.inventorywebservice.inventorymanager.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	public PurchaseRepository purchaseRepository;

	@Autowired
	LoginService loginService;

	public List<PurchaseModel> findAllPurchasesByUser(String userEmail) {

		return null;
	}

	@Override
	public PurchaseResponseBean createNewPurchaseForUser(PurchaseRequestBean purchaseRequestBean) {
		boolean userExists = loginService.checkUserExistForUUID(purchaseRequestBean.getUserUUID());
		if (userExists) {
			PurchaseModel pm = new PurchaseModel();
			pm.setItem_barcode(purchaseRequestBean.getItemBarCode());
			pm.setUser_uuid(purchaseRequestBean.getUserUUID());
			Date d = new Date();
			pm.setCreatedAt(d);
			pm.setModifiedAt(d);
			PurchaseModel newPurchase = purchaseRepository.save(pm);
			PurchaseResponseBean pResBean = new PurchaseResponseBean();
			pResBean.setItemName("testItem");
			pResBean.setMessage("testMessage");
			pResBean.setIsPurchaseSuccessfull(true);
			pResBean.setPurchaseSerial(newPurchase.getPurchaseSerial());
			return pResBean;
		} else {
			PurchaseResponseBean pResBean = new PurchaseResponseBean();
			pResBean.setItemName("testItem");
			pResBean.setMessage("Failed to Add purchase");
			pResBean.setIsPurchaseSuccessfull(false);
			return pResBean;
		}
	}

}
