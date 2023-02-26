package org.makerminds.internship.java.restaurantpoint.controller;


import java.util.LinkedList;
import java.util.List;

import org.makerminds.internship.java.restaurantpoint.model.MenuItem;
import org.makerminds.internship.java.restaurantpoint.model.Products;

public class MenuItemManagerController {
	
	
	MenuItem menuItem=new MenuItem();
	
	private static List<List<Products>>menuItemsForEachList=new LinkedList<>();
	
public void fillTheMenuItemList() {
	menuItemsForEachList.add(0,menuItem.getList());
	menuItemsForEachList.add(1,menuItem.getList2());
	}

public List<List<Products>> getMenuItemsForEachList() {
	return menuItemsForEachList;
}
	
	
public static void main(String[] args) {
	System.out.println(menuItemsForEachList.get(1).toString());
}

}
