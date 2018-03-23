package com.inventorywebservice.inventorymanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.model.PurchaseModel;
import com.inventorywebservice.inventorymanager.service.LoginService;
import com.inventorywebservice.inventorymanager.service.PurchaseService;

@RestController
@RequestMapping("/Login")
public class LoginController {


	public static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	LoginService loginService; //Service which will do all data retrieval/manipulation work

	// -------------------Login and authenticate the User-------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserLoginBean userLoginBean, UriComponentsBuilder ucBuilder) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> IN LOGIN CONTROLLER");
		String userUUID = loginService.doLogin(userLoginBean);

		HttpHeaders headers = new HttpHeaders();
	//	headers.setLocation(ucBuilder.path("/api/Login/{userUUID}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}




}
