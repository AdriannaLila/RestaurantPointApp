package org.makerminds.internship.java.restaurantpoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.makerminds.internship.java.restaurantpoint.model.Tables;

public class TableManagerController {
	
	private List<Tables>listofTables =new ArrayList<Tables>();
	
	
	public TableManagerController() {
		createListOfTables();
	}


	private void createListOfTables() {
		
		listofTables.add(new Tables(1, 5));
		listofTables.add(new Tables(2, 12));
		listofTables.add(new Tables(3, 4));
		listofTables.add(new Tables(4, 10));
		listofTables.add(new Tables(5,2));
		
	}


	public List<Tables> getListofTables() {
		return listofTables;
	}
	

}
