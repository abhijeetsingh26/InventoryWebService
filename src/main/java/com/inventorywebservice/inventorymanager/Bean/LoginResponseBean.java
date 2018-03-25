package com.inventorywebservice.inventorymanager.Bean;

public class LoginResponseBean {
	
	String userUUID;
	
	String userFname;
	
	String userLname;
	
	Boolean isloginVerified;
	
	String message="";


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsloginVerified() {
		return isloginVerified;
	}

	public void setIsloginVerified(Boolean isloginVerified) {
		this.isloginVerified = isloginVerified;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}
	
}
