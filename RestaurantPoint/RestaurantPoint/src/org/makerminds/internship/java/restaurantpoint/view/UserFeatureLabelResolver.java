package org.makerminds.internship.java.restaurantpoint.view;

import java.util.HashMap;
import java.util.Map;

import static org.makerminds.internship.java.restaurantpoint.model.UserFeatures.*;
import  org.makerminds.internship.java.restaurantpoint.model.UserFeatures;


public class UserFeatureLabelResolver {
	

	private static Map<UserFeatures, String> userFeatureLabelMap;
	
	private static Map<UserFeatures, String> getUserFeatureLabelMap(){
		if(userFeatureLabelMap==null) {
			userFeatureLabelMap=new HashMap<>();
			userFeatureLabelMap.put(RESTAURANT_POINT, "Restaurant Point");
			userFeatureLabelMap.put(RESTAURANT, "Restaurant"); 
			userFeatureLabelMap.put(MENU,"Menu");
			userFeatureLabelMap.put(MENU_ITEM,"Menu Item");
			userFeatureLabelMap.put(SIGN_OUT,"Sign out");
			userFeatureLabelMap.put(ORDER,"Order");
			userFeatureLabelMap.put(PLAN,"Plan");
			userFeatureLabelMap.put(SERVICE,"Service");
			userFeatureLabelMap.put(TABLES,"Tables");
			userFeatureLabelMap.put(ORDERS,"Orders");
			userFeatureLabelMap.put(STATUS,"Status");
			
		}
		return userFeatureLabelMap;
	}

	
	public static String getUserFeatureLabel(UserFeatures userFeatures) {
		return getUserFeatureLabelMap().get(userFeatures);
		
	}
}
