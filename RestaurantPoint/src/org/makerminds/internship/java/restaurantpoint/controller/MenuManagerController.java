package org.makerminds.internship.java.restaurantpoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.makerminds.internship.java.restaurantpoint.model.Menu;

public class MenuManagerController {
	
	private List<Menu>listOfMenus=new ArrayList<>();
	
	
	public MenuManagerController(){
		createListOfMenus();
	}


	private void createListOfMenus() {
		listOfMenus.add(new Menu("Menu#1"));
		listOfMenus.add(new Menu("Menu#2"));
		listOfMenus.add(new Menu("Menu#3"));
		listOfMenus.add(new Menu("Menu#4"));
		
		
	}


	public List<Menu> getListOfMenus() {
		return listOfMenus;
	}
	

}
