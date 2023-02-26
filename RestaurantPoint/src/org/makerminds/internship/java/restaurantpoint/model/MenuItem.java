package org.makerminds.internship.java.restaurantpoint.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class MenuItem {
	/*Üprivate HashMap<Integer,Products>menuItems=new HashMap<>();
	
	public MenuItem() {
		initializeMenuItems();
	}
	private void initializeMenuItems() {
		menuItems.put(100, new Meal("Hamburger",100,3.5,"Tomato,pickles,ketchup"));
		menuItems.put(101, new Products("Cheeseburger",101,5));
		menuItems.put(102, new Products("Sandwich",102,3));
		menuItems.put(103, new Products("Hotdog",103,3.5));
		menuItems.put(104, new Products("Pizza",104,6));
		menuItems.put(105, new Products("Fries",105,5));
		menuItems.put(200, new Drink("Cola cola",200,1,false));  
		menuItems.put(201, new Drink("Cola cola Zero",201,1,true));
		menuItems.put(202, new Products("Fanta",202,1));
		menuItems.put(203, new Products("Sprite",203,1));
		menuItems.put(204, new Products("Red Bull",204,2));
		menuItems.put(205, new Products("Coffee",205,0.5));
		menuItems.put(300, new Products("Ice Cream",300,1.6));
		menuItems.put(301, new Products("Waffle",301,2.9));
		menuItems.put(302, new Products("Brownie",302,3));
	}
	
	public HashMap<Integer,Products> getMenuItems(){
		return menuItems;
}
	*/
	
	private List<Products>list=new ArrayList<>();
	
	public MenuItem() {
		filltheList();
	}
	
	
	private void filltheList() {
		list.add(new Products("Cheeseburger",101,5));
		list.add(new Products("Fanta",202,1));
		list.add(new Products("Red Bull",204,2));
		list.add(new Products("Brownie",302,3));
		list.add(new Products("Pizza",104,6));
		
	}
	
	
	public List<Products> getList() {
		return list;
	}
	/**private List<List<Products>> bigList=new ArrayList<>();
	
	public MenuItem() {
		fillTheList();
	}

private List<Products>listOne=new ArrayList<>();
private List<Products>listTwo=new ArrayList<>();
	 private List<Products> initializeMenuItems1() {
	  
	 listOne.add(new Products("Cake", 200, 8.9));
	 listOne.add(new Products("Cake", 200, 8.9));
	 listOne.add(new Products("Cake", 200, 8.9));
	 listOne.add(new Products("Cake", 200, 8.9));

	 return listOne;
	 }
	 private List<Products> initializeMenuItems2() {
		  
		 listTwo.add(new Products("Cake", 200, 8.9));
		 listTwo.add(new Products("Cake", 200, 8.9));
		 listTwo.add(new Products("Cake", 200, 8.9));
		 return listTwo;
		 }
	 
	 
	 private List<List<Products>> fillTheList(){
		 
		 bigList.add(initializeMenuItems1());
		 bigList.add(initializeMenuItems2());
		 return bigList;
	 }
}
*/
}
