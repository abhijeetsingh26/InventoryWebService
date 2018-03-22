package com.inventorywebservice.inventorymanager.dao;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;

public interface LoginDAO {
	
	Boolean checkUserExists(UserLoginBean userLoginBean);
	Boolean createNewUserAssociation(UserLoginBean userLoginBean);
}
