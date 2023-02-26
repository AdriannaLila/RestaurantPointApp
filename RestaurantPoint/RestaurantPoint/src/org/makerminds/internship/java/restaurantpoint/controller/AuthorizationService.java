package org.makerminds.internship.java.restaurantpoint.controller;

import java.util.Arrays;

import java.util.List;

import org.makerminds.internship.java.restaurantpoint.model.UserFeatures;
import static org.makerminds.internship.java.restaurantpoint.model.UserFeatures.*;
import org.makerminds.internship.java.restaurantpoint.model.UserRole;

public class AuthorizationService {

	public List<UserFeatures>getUserFeaturesByUserRole(UserRole userRole){
		switch(userRole) {
	case RESTAURANT_ADMIN:
		return Arrays.asList(RESTAURANT_POINT,RESTAURANT,MENU,MENU_ITEM,SIGN_OUT);
	case WAITER:
		return Arrays.asList(TABLES,ORDERS,STATUS);
	case COOKER:
		return Arrays.asList(ORDER,PLAN,SERVICE);
		default:
			throw new IllegalArgumentException("The user role " +userRole+ " is not supported!");
}
		
	}
}
