package com.inventorywebservice.inventorymanager.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.model.EnduserModel;
import com.inventorywebservice.inventorymanager.repository.LoginRepository;
import com.inventorywebservice.inventorymanager.util.AuthTokenVerifier;;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginRepository loginDAO;

	@Override
	public synchronized String doLogin(UserLoginBean userLoginBean) {
		HashMap<String, String> userDataMap = new HashMap<>();
		Boolean isAccVerified = AuthTokenVerifier.verifyToken(userLoginBean.getIdToken(), userDataMap);
		if(isAccVerified)
		{
		String userId = checkUser(userDataMap);
		if (userId != null)
			return userId;
		else
			return null;
		}
		else
			return null;
	}


	@Override
	public String checkUser(HashMap<String, String> userDataMap) 
	{
			String userEmail = userDataMap.get("email");
			List<EnduserModel> userList = loginDAO.findByuserEmail(userEmail);
			if (userList.size() > 0)
				return userList.get(0).getuserUUID().toString();
			else
				return createNewUserAssociation(userDataMap);
	}

	@Override
	public String createNewUserAssociation(HashMap<String, String> userDataMap) {
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		EnduserModel em = new EnduserModel();
		em.setUserEmail(userDataMap.get("email"));
		em.setuserUUID(randomUUIDString);
		em.setUserFirstName(userDataMap.get("givenName"));
		em.setUserLastName(userDataMap.get("familyName"));
		Date d = new Date();
		em.setCreatedAt(d);
		em.setModifiedAt(d);
		EnduserModel newUser = loginDAO.save(em);
		return newUser.getuserUUID().toString();
	}




}
