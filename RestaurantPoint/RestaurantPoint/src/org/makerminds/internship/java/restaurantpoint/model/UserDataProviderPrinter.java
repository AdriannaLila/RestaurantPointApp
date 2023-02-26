package org.makerminds.internship.java.restaurantpoint.model;

import java.util.List;

import org.makerminds.internship.java.restaurantpoint.controller.UserDataProvider;

public class UserDataProviderPrinter {
	public static void main(String[] args) {
		UserDataProvider userDataProvider=new UserDataProvider();
	    UserDataProviderPrinter userDataProviderPrinter=new UserDataProviderPrinter();
	   
	   userDataProviderPrinter.displayUserAccountList(userDataProvider.getUserList());
	  
	}
	
	private void displayUserAccountList(List<User>userList) {
		
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("----------------------------USER ACCOUNTS LIST----------------------------").append(System.lineSeparator());
		
		for(User user : userList) {
			for(int i=0;i<user.getListOfRestaurants().size();i++) {
			stringBuilder.append("User Role: ").append(user.getUserRole()).append(System.lineSeparator());
			stringBuilder.append("Username of User: ").append(user.getUsernameString()).append(System.lineSeparator());
			stringBuilder.append("Restaurants of User: ").append("|").append(user.getListOfRestaurants().get(i).getName()).append(",");
			stringBuilder.append(user.getListOfRestaurants().get(i).getAddress()).append("|").append(System.lineSeparator());
			stringBuilder.append("--------------------------------------------------------------------------");
			stringBuilder.append(System.lineSeparator());
		} 
		}
		System.out.println(stringBuilder);
	}
	}
	
