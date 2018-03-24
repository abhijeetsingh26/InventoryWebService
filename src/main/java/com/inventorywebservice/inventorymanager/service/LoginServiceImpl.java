package com.inventorywebservice.inventorymanager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.model.EnduserModel;
import com.inventorywebservice.inventorymanager.repository.LoginRepository;;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginRepository loginDAO;

	@Override
	public synchronized String doLogin(UserLoginBean userLoginBean) {
		String userId = checkUserExists(userLoginBean.getUser_email());
		if (userId != null)
			return userId;
		else
			return null;
	}

	@Override
	public String checkUserExists(String userEmail) {
		List<EnduserModel> userList = loginDAO.findByuserEmail(userEmail);
		if (userList.size() > 0)
			return userList.get(0).getUserId().toString();
		else
			return createNewUserAssociation(userEmail);
	}

	@Override
	public String createNewUserAssociation(String userEmail) {
		EnduserModel em = new EnduserModel();
		em.setUserEmail(userEmail);
		Date d = new Date();
		em.setCreatedAt(d);
		em.setModifiedAt(d);
		EnduserModel newUser =  loginDAO.save(em);
		return newUser.getUserId().toString();
	}

}
