package org.makerminds.internship.java.restaurantpoint.controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.makerminds.internship.java.restaurantpoint.model.Menu;
public class MenuManagerController {
	
	private static List<Menu>list1=new ArrayList<>();
	private static List<Menu>list3=new ArrayList<>();
	private static List<Menu>list2=new ArrayList<>();
	//private static MenuItem menuItem=new MenuItem();
	private List<List<Menu>>listOfMenusList=new LinkedList<>();
	
	private List<Menu>menuListWaiter=new ArrayList<>();

	public List<Menu> getMenuListWaiter() {
		menuListWaiter.add(new Menu("Menu #1"));
		menuListWaiter.add(new Menu("Menu #2"));
		return menuListWaiter;
	}

	public MenuManagerController(){
		createListOfMenus1();
		createListOfMenus2();
		createListOfMenus3();
	}

	private List<Menu> createListOfMenus1() {
		list1.add(new Menu("Menu#1"));
		list1.add(new Menu("Menu#2"));
		list1.add(new Menu("Menu#3"));
		list1.add(new Menu("Menu#4"));
		
		return list1;
	}
	private List<Menu> createListOfMenus2() {
		list2.add(new Menu("Menu#1"));
		list2.add(new Menu("Menu#2"));
		
		return list2;
	}
	private List<Menu> createListOfMenus3() {
		list3.add(new Menu("Menu#1"));
		list3.add(new Menu("Menu#2"));
		list3.add(new Menu("Menu#3"));
	
		
		return list3;
	}
	
	public List<List<Menu>> getListOfMenus() {
		listOfMenusList.add(getList1());
		listOfMenusList.add(getList2());
		listOfMenusList.add(getList3());
		return listOfMenusList;
	}

	public static List<Menu> getList1() {
		return list1;
	}

	public static List<Menu> getList3() {
		return list3;
	}

	public static List<Menu> getList2() {
		return list2;
	}
	
	

}
