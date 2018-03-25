package com.inventorywebservice.inventorymanager.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorywebservice.inventorymanager.Bean.LoginResponseBean;
import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.model.EnduserModel;
import com.inventorywebservice.inventorymanager.repository.LoginRepository;
import com.inventorywebservice.inventorymanager.util.AuthTokenVerifier;;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginRepository loginDAO;

	@Override
	public synchronized LoginResponseBean doLogin(UserLoginBean userLoginBean) {
		HashMap<String, String> userDataMap = new HashMap<>();
		Boolean isAccVerified = AuthTokenVerifier.verifyToken(userLoginBean.getIdToken(), userDataMap);
		if(isAccVerified)
		{
			EnduserModel enduserModel = checkUser(userDataMap);
			
			//Construct a login Response Bean from the data
			LoginResponseBean lrb =  new LoginResponseBean();
			lrb.setIsloginVerified(isAccVerified);
			lrb.setUserFname(enduserModel.getUserFirstName());
			lrb.setUserLname(enduserModel.getUserLastName());
			lrb.setUserUUID(enduserModel.getuserUUID());
			lrb.setMessage("User Logged In.");
			return lrb;
		}
		else
		{
			LoginResponseBean lrb =  new LoginResponseBean();
			lrb.setIsloginVerified(isAccVerified);
			lrb.setMessage("User Authentication Failed. Re-Login to continue.");
			return lrb;
		}
	}


	@Override
	public EnduserModel checkUser(HashMap<String, String> userDataMap) 
	{
			String userEmail = userDataMap.get("email");
			List<EnduserModel> userList = loginDAO.findByuserEmail(userEmail);
			if (userList.size() > 0)
				return userList.get(0);
			else
				return createNewUserAssociation(userDataMap);
	}

	@Override
	public EnduserModel createNewUserAssociation(HashMap<String, String> userDataMap) {
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
		return newUser;
	}




}
