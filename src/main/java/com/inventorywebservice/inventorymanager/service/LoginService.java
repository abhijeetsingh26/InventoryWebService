package com.inventorywebservice.inventorymanager.service;

import java.util.HashMap;

import com.inventorywebservice.inventorymanager.Bean.LoginResponseBean;
import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.model.EnduserModel;

public interface LoginService {
	
	LoginResponseBean doLogin(UserLoginBean userLoginBean);
	EnduserModel checkUser(HashMap<String, String> userDataMap);
	EnduserModel createNewUserAssociation(HashMap<String, String> userDataMap);
}
