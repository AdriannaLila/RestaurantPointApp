package org.makerminds.internship.java.restaurantpoint.controller;


import java.util.ArrayList;
import java.util.List;

import org.makerminds.internship.java.restaurantpoint.model.Restaurant;

public class RestaurantManagerController {
	
private List<Restaurant>listOfRestaurants=new ArrayList<>();

public RestaurantManagerController() {
	createListOfRestaurants();
}

private void createListOfRestaurants() {
	listOfRestaurants.add(new Restaurant("Artigiano", "Blloku"));
	listOfRestaurants.add(new Restaurant("D'Angelo", "21 Djetori"));
	listOfRestaurants.add(new Restaurant("Ulliri", "Teg"));
}

public List<Restaurant> getListOfRestaurants() {
	return listOfRestaurants;
}


}
