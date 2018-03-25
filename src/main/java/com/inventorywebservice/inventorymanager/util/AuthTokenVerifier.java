package com.inventorywebservice.inventorymanager.util;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Authenticator;
import org.apache.catalina.connector.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.inventorywebservice.inventorymanager.controller.LoginController;

public class AuthTokenVerifier {
	private static final JacksonFactory jacksonFactory = new JacksonFactory();
	static NetHttpTransport transport = new NetHttpTransport();
      static Properties prop =  ReadProperties.getInstance().readConfigProperties();
	
      public static Boolean verifyToken(String token, HashMap<String, String> userDataMap) {
    	  Boolean isVerified =  false;
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
				.setAudience(Collections
						.singletonList(prop.getProperty("CLIENT_ID").trim()))
				.build();

		GoogleIdToken idToken = null;
		try {
			idToken = verifier.verify(token);
		} catch (GeneralSecurityException | IOException e) {
			LogUtils.logDebug("Token Verification error",e);
		}
		if (idToken != null) {
			isVerified = true;
			Payload payload = idToken.getPayload();

			// Print user identifier
			String userId = payload.getSubject();
			// System.out.println("User ID: " + userId);

			// Get profile information from payload
			String email = payload.getEmail();
			boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			String name = (String) payload.get("name");
		//	String pictureUrl = (String) payload.get("picture");
		//	String locale = (String) payload.get("locale");
			String familyName = (String) payload.get("family_name");
			String givenName = (String) payload.get("given_name");
			System.out.println(">>>>>Token Verified" +"emailVerified: " +emailVerified + ", email:  " + email + ", name:  " + name + ", familyName: " + familyName + ", givenName:  " + givenName);
			
			userDataMap.put("email", email);
			userDataMap.put("name", name);
			userDataMap.put("familyName",familyName );
			userDataMap.put("givenName",givenName );
			userDataMap.put("userId",userId );
		} else {
			isVerified = false;;
			System.out.println("Invalid ID token.");
		}
		return isVerified;
	}
}
