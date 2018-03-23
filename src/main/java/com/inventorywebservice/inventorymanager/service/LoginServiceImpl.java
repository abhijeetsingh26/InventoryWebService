package com.inventorywebservice.inventorymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	public LoginDAO loginDAO;
	public void setPersonDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	
	
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
		System.out.println(">>>>>>>>>>>>>>> In check user exists");
		return loginDAO.checkUserExists(userLoginBean);
	}

	@Override
	public Boolean createNewUserAssociation(UserLoginBean userLoginBean) {
		
		return null;
	}

}
