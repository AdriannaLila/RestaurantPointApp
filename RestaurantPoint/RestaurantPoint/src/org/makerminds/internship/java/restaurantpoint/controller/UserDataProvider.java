package org.makerminds.internship.java.restaurantpoint.controller;
import java.util.ArrayList;
import java.util.List;
import org.makerminds.internship.java.restaurantpoint.model.User;
import org.makerminds.internship.java.restaurantpoint.model.UserRole;

public class UserDataProvider {
	
	public List<User> userList=new ArrayList<>();
	
	public UserDataProvider() {
		userList.add(new User("testUser1", "test123", UserRole.RESTAURANT_ADMIN));
		userList.add(new User("testUser2", "wait123", UserRole.WAITER));
		userList.add(new User("testUser3", "wait567", UserRole.WAITER));
		userList.add(new User("testUser4", "cooker123", UserRole.COOKER));
		
	}

	public List<User> getUserList() {
		return userList;
	}

	
}
