package org.makerminds.internship.java.restaurantpoint.model;

import java.util.List;

public class Menu {

	
	private String name;
	private List<Products>listOfMenuItems;

	public Menu(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Products> getListOfMenuItems() {
		return listOfMenuItems;
	}

	public void setListOfMenuItems(List<Products> listOfMenuItems) {
		this.listOfMenuItems = listOfMenuItems;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
