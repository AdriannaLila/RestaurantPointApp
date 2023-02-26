package org.makerminds.internship.java.restaurantpoint.model;
import java.util.List;

import org.makerminds.internship.java.restaurantpoint.controller.MenuManagerController;
import org.makerminds.internship.java.restaurantpoint.controller.TableManagerController;
public class Mainn {
	public static void main(String[] args) {
		MenuItem menuItem=new MenuItem();
		
		List<List<Products>> listOfListsOfProductsList=menuItem.getListOfListsOfProductsList();
		
		for(List<Products>list:listOfListsOfProductsList) {
			for(int i=0;i<list.size();i++) {
		
		System.out.println(" "+ list.get(i));
			}
	}
		System.out.println();
		
	
   List<Products>list1=listOfListsOfProductsList.get(0);
   for (int i=0;i<list1.size();i++) {
	   System.out.println(" "+ list1.get(i));
   }

	TableManagerController tableManagerController=new TableManagerController();
	List<List<Tables>> listOfTabList=tableManagerController.getListofTables();
	
	for (int i=0;i<listOfTabList.size();i++) {
		   System.out.println(" "+ listOfTabList.get(i));
	   }

	MenuManagerController menuManagerController=new MenuManagerController();
	
	List<List<Menu>>list=menuManagerController.getListOfMenus();
	for (int i=0;i<list.size();i++) {
		   System.out.println(" "+ list.get(i));
	   }
}
}