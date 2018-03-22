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

import com.inventorywebservice.inventorymanager.model.PurchaseModel;
import com.inventorywebservice.inventorymanager.model.User;
import com.inventorywebservice.inventorymanager.service.PurchaseService;
import com.inventorywebservice.inventorymanager.service.UserService;
import com.inventorywebservice.inventorymanager.util.CustomErrorType;
@RestController
@RequestMapping("/item")
public class PurchaseController {

	public static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	PurchaseService purchaseService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All The Purchases made by the user---------------------------------------------

	@RequestMapping(value = "/purchase/{}", method = RequestMethod.GET)
	public ResponseEntity<List<PurchaseModel>> listAllPurchasesByUser(@RequestParam String userEmail) {
		List<PurchaseModel> purchaseByUsers = purchaseService.findAllPurchasesByUser(userEmail);
		if (purchaseByUsers.isEmpty()) {
			return new ResponseEntity<List<PurchaseModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PurchaseModel>>(purchaseByUsers, HttpStatus.OK);
	}

	// -------------------Create a Purchase for the user-------------------------------------------
/*
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", user);

		if (userService.isUserExist(user)) {
			logger.error("Unable to create. A User with name {} already exist", user.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
			user.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}*/


}
