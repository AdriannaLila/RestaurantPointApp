package org.makerminds.internship.java.restaurantpoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.makerminds.internship.java.restaurantpoint.model.MenuItem;
import org.makerminds.internship.java.restaurantpoint.model.Restaurant;
import org.makerminds.internship.java.restaurantpoint.model.Tables;
import org.makerminds.internship.java.restaurantpoint.model.User;
import org.makerminds.internship.java.restaurantpoint.model.UserRole;

public class UserDataProvider {
	
	public List<User> userList=new ArrayList<>();
	
	public UserDataProvider() {
		createUserRestaurantAccount();
	}
	
	private void createUserRestaurantAccount() {
		createUserRestaurantAccount1();
		createUserRestaurantAccount2();
		createUserRestaurantAccount3();
		
	}

	public void createUserRestaurantAccount1() {
		User user1=new User("logAdmin", "pass123", UserRole.RESTAURANT_ADMIN);
		userList.add(user1);
		
		List<Restaurant>listOfRestaurants=new ArrayList<>();
		Restaurant restaurant1=new Restaurant("Artigano", "Bllok");
		Restaurant restaurant2=new Restaurant("Aroma", "21 Street");
		listOfRestaurants.add(restaurant1);
		listOfRestaurants.add(restaurant2);
		user1.setListOfRestaurants(listOfRestaurants);
		
		Tables tables1=new Tables(1, 10);
		Tables tables2=new Tables(2, 4);
		Tables tables3 = new Tables(3,15);
		Tables tables4=new Tables(4, 2);
		List<Tables>tables=new ArrayList<>();
		tables.add(tables1);
		tables.add(tables2);
		tables.add(tables3);
		tables.add(tables4);
		
		restaurant1.setTablesList(tables);
		restaurant2.setTablesList(tables);
		
		MenuItem menu=new MenuItem();
		List<MenuItem>menus=new ArrayList<>();
		//menu.getMenuItems();
        menus.add(menu);
        
        restaurant1.setMenuList(menus);
        restaurant2.setMenuList(menus);
		
		
	}
	public void createUserRestaurantAccount2() {
		User user2=new User("logWaiter", "pass456", UserRole.WAITER);
		//userList.add(user2);
		
		List<Restaurant>listOfRestaurants=new ArrayList<>();
		Restaurant restaurant1=new Restaurant("Fish Time ", "Don Bosco");
		listOfRestaurants.add(restaurant1);
		user2.setListOfRestaurants(listOfRestaurants);
		
		Tables tables1=new Tables(1, 2);
		Tables tables2=new Tables(2, 20);
		Tables tables3 = new Tables(3,8);
		Tables tables4=new Tables(4, 4);
		List<Tables>tables=new ArrayList<>();
		tables.add(tables1);
		tables.add(tables2);
		tables.add(tables3);
		tables.add(tables4);
		
		restaurant1.setTablesList(tables);
	
		MenuItem menu=new MenuItem();
		List<MenuItem>menus=new ArrayList<>();
	//	menu.getMenuItems();
      //  menus.add(menu);
        restaurant1.setMenuList(menus);
 
	}
	
	public void createUserRestaurantAccount3() {
		User user3=new User("logWaiter", "pass789", UserRole.WAITER);
		//userList.add(user3);
		
		List<Restaurant>listOfRestaurants=new ArrayList<>();
		Restaurant restaurant1=new Restaurant("Yogurteria", "Mother Teresa Square");
		listOfRestaurants.add(restaurant1);
		user3.setListOfRestaurants(listOfRestaurants);
		
		Tables tables1=new Tables(1, 12);
		Tables tables2=new Tables(2, 4);
		Tables tables3 = new Tables(3,16);
		Tables tables4=new Tables(4, 5);
		List<Tables>tables=new ArrayList<>();
		tables.add(tables1);
		tables.add(tables2);
		tables.add(tables3);
		tables.add(tables4);
		
		restaurant1.setTablesList(tables);
	
		MenuItem menu=new MenuItem();
		List<MenuItem>menus=new ArrayList<>();
//menu.getMenuItems();
  // menus.add(menu);
        restaurant1.setMenuList(menus);
 
	}

	public List<User> getUserList() {
		return userList;
	}

	
}
