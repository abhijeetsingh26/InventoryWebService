package com.inventorywebservice.inventorymanager.service;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;

public interface LoginService {
	
	String doLogin(UserLoginBean userLoginBean);
	String checkUserExists(String userEmail);
	String createNewUserAssociation(String userEmail);
}
