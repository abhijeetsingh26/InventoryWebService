package com.inventorywebservice.inventorymanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.service.LoginService;

@RestController
@RequestMapping("/Login")
public class LoginController {


	public static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	LoginService loginService;

	// -------------------Login and authenticate the User-------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserLoginBean userLoginBean, UriComponentsBuilder ucBuilder) {
		String userUUID = loginService.doLogin(userLoginBean);

		HttpHeaders headers = new HttpHeaders();
	//	headers.setLocation(ucBuilder.path("/api/Login/{userUUID}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}




}
