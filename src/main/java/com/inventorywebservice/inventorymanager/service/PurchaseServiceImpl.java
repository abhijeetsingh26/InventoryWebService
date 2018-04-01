package com.inventorywebservice.inventorymanager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorywebservice.inventorymanager.Bean.PurchaseDetailsResponseBean;
import com.inventorywebservice.inventorymanager.Bean.PurchaseRequestBean;
import com.inventorywebservice.inventorymanager.Bean.PurchaseResponseBean;
import com.inventorywebservice.inventorymanager.model.ItemDetailsModel;
import com.inventorywebservice.inventorymanager.model.PurchaseModel;
import com.inventorywebservice.inventorymanager.repository.ItemDetailsRepository;
import com.inventorywebservice.inventorymanager.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	public PurchaseRepository purchaseRepository;

	@Autowired
	LoginService loginService;
	
	@Autowired
	ItemDetailsRepository itemDetailsRepository;

	public List<PurchaseDetailsResponseBean> findAllPurchasesByUser(String userUUID) {
			List<PurchaseModel> allUsers = purchaseRepository.findByuserUuid(userUUID);
			System.out.println(">>>>userUUID" + userUUID);
			System.out.println(">>>>> ALLUSERS"+ allUsers);
			List<PurchaseDetailsResponseBean> pDetailsResponseBean = new ArrayList<>();
			List<ItemDetailsModel> allItemDetails = itemDetailsRepository.findAll();
			
			for(PurchaseModel currentPurchaseForUser:allUsers)
			{
				String currentBarcode = currentPurchaseForUser.getItemBarcode();
				for(ItemDetailsModel currentItemDetails: allItemDetails)
				{
					if(currentItemDetails.getItemBarcode().equals(currentBarcode))
					{
						PurchaseDetailsResponseBean cpdrs = new PurchaseDetailsResponseBean();
						cpdrs.setCreatedAt(currentPurchaseForUser.getCreatedAt());
						cpdrs.setItemBarcode(currentPurchaseForUser.getItemBarcode());
						cpdrs.setItemName(currentItemDetails.getItemName());
						cpdrs.setItemPrice(currentItemDetails.getItemPrice());
						cpdrs.setModifiedAt(currentPurchaseForUser.getModifiedAt());
						cpdrs.setPurchaseSerial(currentPurchaseForUser.getPurchaseSerial());
						cpdrs.setUserUuid(currentPurchaseForUser.getUserUuid());
						
						pDetailsResponseBean.add(cpdrs);
					}
				}
			}
		return pDetailsResponseBean;
	}

	@Override
	public String getTotalAmountFromPurchaseList(List<PurchaseDetailsResponseBean> pdrb) {
		Integer total = 0;
		for(PurchaseDetailsResponseBean currentPRB:pdrb)
		{
			total = total +currentPRB.getItemPrice();
		}
		return total.toString();
	}

	@Override
	public PurchaseResponseBean createNewPurchaseForUser(PurchaseRequestBean purchaseRequestBean) {
		boolean userExists = loginService.checkUserExistForUUID(purchaseRequestBean.getUserUUID());
		if (userExists) {
			PurchaseModel pm = new PurchaseModel();
			pm.setItemBarcode(purchaseRequestBean.getItemBarCode());
			pm.setUserUuid(purchaseRequestBean.getUserUUID());
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
