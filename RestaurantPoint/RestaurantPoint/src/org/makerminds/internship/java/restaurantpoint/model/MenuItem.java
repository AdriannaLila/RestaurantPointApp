package org.makerminds.internship.java.restaurantpoint.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class MenuItem {
	private  List<List<Products>>listOfListsOfProductsList=new LinkedList<>();
	private  List<Products>list=new ArrayList<>();
	private  List<Products>listTwo=new ArrayList<>();
	
	public MenuItem() {
		filltheList();
		filltheList2();
	}
	private void filltheList() {
		list.add(new Products("Cheeseburger",101,5));
		list.add(new Products("Fanta",202,1));
		list.add(new Products("Red Bull",204,2.25));
		list.add(new Products("Brownie",302,3));
		list.add(new Products("Pizza",104,6.6));
		
	}
	public  List<Products> getList() {
		return list;
	}
	
	public void filltheList2() {
		listTwo.add(new Products("Hotdog",101,5));
		listTwo.add(new Products("Pepsi",202,1.5));
		listTwo.add(new Products("Cola",204,2.8));
		listTwo.add(new Products("Tiramisu",302,3));
		listTwo.add(new Products("Noodles",104,6));
		
	}
	public List<Products> getList2() {
		return listTwo;
	}
	
	
	public  List<List<Products>>getListOfListsOfProductsList(){
		listOfListsOfProductsList.add(getList());
		listOfListsOfProductsList.add(getList2());
		return listOfListsOfProductsList;
	}
}
