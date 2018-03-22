package com.inventorywebservice.inventorymanager.service;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;

public interface LoginService {
	
	String doLogin(UserLoginBean userLoginBean);
	Boolean checkUserExists(UserLoginBean userLoginBean);
	Boolean createNewUserAssociation(UserLoginBean userLoginBean);
}
