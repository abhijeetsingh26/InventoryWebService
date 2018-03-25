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

import com.inventorywebservice.inventorymanager.Bean.LoginResponseBean;
import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.service.LoginService;
import com.inventorywebservice.inventorymanager.util.AuthTokenVerifier;
import com.inventorywebservice.inventorymanager.util.CustomBodyType;
import com.inventorywebservice.inventorymanager.util.CustomErrorType;

@RestController
@RequestMapping("/Login")
public class LoginController {


	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	// -------------------Login and authenticate the User-------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserLoginBean userLoginBean, UriComponentsBuilder ucBuilder) {
		LoginResponseBean loginResponseBean = loginService.doLogin(userLoginBean);
		HttpHeaders headers = new HttpHeaders();
		
		if(loginResponseBean.getIsloginVerified())
		{
			headers.set("Content-Type", "application/json");
			//return new ResponseEntity(new CustomErrorType("Unable to create. A User with name already exist."), HttpStatus.OK);
			return new ResponseEntity<LoginResponseBean>(loginResponseBean, headers, HttpStatus.OK);
		}			
		else
		{		
			loginResponseBean.setMessage("Dang, User Authentication Failed. Re-Login to continue.");
			return new ResponseEntity<LoginResponseBean>(loginResponseBean,headers, HttpStatus.UNAUTHORIZED);
		}
	}




}
