package com.inventorywebservice.inventorymanager.service;

import java.util.HashMap;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;

public interface LoginService {
	
	String doLogin(UserLoginBean userLoginBean);
	String checkUser(HashMap<String, String> userDataMap);
	String createNewUserAssociation(HashMap<String, String> userDataMap);
}
