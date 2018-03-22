package com.inventorywebservice.inventorymanager.service;

import org.springframework.stereotype.Service;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Override
	public String doLogin(UserLoginBean userLoginBean) {
		if(!checkUserExists(userLoginBean))
		{
			createNewUserAssociation(userLoginBean);
		}
		else
		{
			
		}
		return null;
	}

	@Override
	public Boolean checkUserExists(UserLoginBean userLoginBean) {
		
		return null;
	}

	@Override
	public Boolean createNewUserAssociation(UserLoginBean userLoginBean) {
		
		return null;
	}

}
