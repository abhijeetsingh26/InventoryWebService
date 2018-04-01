package com.inventorywebservice.inventorymanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inventorywebservice.inventorymanager.Bean.PurchaseDetailsResponseBean;
import com.inventorywebservice.inventorymanager.Bean.PurchaseRequestBean;
import com.inventorywebservice.inventorymanager.Bean.PurchaseResponseBean;
import com.inventorywebservice.inventorymanager.model.PurchaseModel;
import com.inventorywebservice.inventorymanager.service.PurchaseService;
import com.inventorywebservice.inventorymanager.util.CustomErrorType;
@RestController
@RequestMapping("/item")
public class PurchaseController {

	public static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	PurchaseService purchaseService;

	// -------------------Retrieve All The Purchases made by the user---------------------------------------------

	@RequestMapping(value = "/purchase/{userUUID}", method = RequestMethod.GET)
	public ResponseEntity<List<PurchaseDetailsResponseBean>> listAllPurchasesByUser(@PathVariable("userUUID") String userUUID) {
		List<PurchaseDetailsResponseBean> purchaseByUsers = purchaseService.findAllPurchasesByUser(userUUID);
		if (purchaseByUsers.isEmpty()) 
		{
			return new ResponseEntity<List<PurchaseDetailsResponseBean>>(HttpStatus.NO_CONTENT);
		}
		else
		{	HttpHeaders headers = new HttpHeaders();
			headers.add("TotalAmount", purchaseService.getTotalAmountFromPurchaseList(purchaseByUsers));
			return new ResponseEntity<List<PurchaseDetailsResponseBean>>(purchaseByUsers,headers, HttpStatus.OK);
		}
	}

	
	// -------------------Create a Purchase for the user-------------------------------------------

	@RequestMapping(value = "/purchase/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody PurchaseRequestBean prb, UriComponentsBuilder ucBuilder) {
		PurchaseResponseBean pResBean = purchaseService.createNewPurchaseForUser(prb);
		Boolean isPurchaseSuccessful = pResBean.getIsPurchaseSuccessfull();
		HttpHeaders headers = new HttpHeaders();
		if(isPurchaseSuccessful)
		{
			return new ResponseEntity<PurchaseResponseBean>(pResBean,headers, HttpStatus.CREATED);
		}
		else
		{			
			return new ResponseEntity<PurchaseResponseBean>(pResBean,headers, HttpStatus.UNAUTHORIZED);		

		}
	}


}
