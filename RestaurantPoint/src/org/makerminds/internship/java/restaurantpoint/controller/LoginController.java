package org.makerminds.internship.java.restaurantpoint.controller;

import org.makerminds.internship.java.restaurantpoint.model.User;

public class LoginController {
	
	private static final LoginController INSTANCE=new LoginController();
	
	private UserDataProvider userDataProvider=new UserDataProvider();
	
	private User loggedInUser=null;
	
	private LoginController() {
		
	}
	
	public User getLoggedInUser() {
		return loggedInUser;
	}

	/**
	 * Find the user from the user list based on the provided username
	 * and password.
	 * 
	 * @param username
	 * @param password
	 */
	
	public void loginUser(String username,String password) {
		for(User user : userDataProvider.getUserList()) {
			if(user.getUsernameString().equals(username) &&
					user.getPassword().equals(password)
					) {
			
			loggedInUser=user;
		}
	}
}
	
	public static LoginController getInstance() {
		return INSTANCE;
		
	}

	public boolean isStringNullOrBlank(String stringText) {
		return stringText==null || stringText.isBlank();
	}
	
	
	

}
