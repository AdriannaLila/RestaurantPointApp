package org.makerminds.internship.java.restaurantpoint.model;

import java.util.List;

public class User {
	private String usernameString;
	private String password;
	private UserRole userRole;
	private List<Restaurant>listOfRestaurants;
	
	
	
	public User(String usernameString, String password, UserRole userRole) {
		super();
		this.usernameString = usernameString;
		this.password = password;
		this.userRole = userRole;
	}
	public String getUsernameString() {
		return usernameString;
	}
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public List<Restaurant> getListOfRestaurants() {
		return listOfRestaurants;
	}
	public void setListOfRestaurants(List<Restaurant> listOfRestaurants) {
		this.listOfRestaurants = listOfRestaurants;
	}
	

}
