package org.makerminds.internship.java.restaurantpoint.model;

import java.util.List;

public class Restaurant {
	
 private String name;
 private String address;
 private List<Tables>tablesList;
 private List<MenuItem>menuList;
 
public Restaurant(String name, String address) {
	this.name = name;
	this.address = address;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public List<Tables> getTablesList() {
	return tablesList;
}

public void setTablesList(List<Tables> tablesList) {
	this.tablesList = tablesList;
}
public void setMenuList(List<MenuItem> menuList) {
	this.menuList = menuList;
}
public List<MenuItem> getMenuList() {
	return menuList;
}
@Override
public String toString() {
	return  name +" | " + address ;
}





}
