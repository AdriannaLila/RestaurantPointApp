package org.makerminds.internship.java.restaurantpoint.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.makerminds.internship.java.restaurantpoint.model.Tables;

public class TableManagerController {
	private List<Tables>tablesForWaiterView=new ArrayList<>();
	private List<List<Tables>> listOfTables=new LinkedList<>();
	private List<Tables>list1=new ArrayList<>();
	private List<Tables>list2=new ArrayList<>();
	private List<Tables>list3=new ArrayList<>();
	
	public TableManagerController() {
		createTables1();
		createTables2();
		createTables3();
	}	
	public List<Tables>createTables1(){
		list1.add(new Tables(1, 5));
		list1.add(new Tables(2, 12));
		list1.add(new Tables(3, 4));
		list1.add(new Tables(4, 10));
		list1.add(new Tables(5,2));
		return list1;
		
	}
	
	public List<Tables> getList1() {
		return list1;
	}

	public List<Tables>createTables2(){
		list2.add(new Tables(1, 7));
		list2.add(new Tables(2, 10));
		list2.add(new Tables(3, 30));
		return list1;
		
	}
	
	public List<Tables> getList2() {
		return list2;
	}
	public List<Tables>createTables3(){
		list3.add(new Tables(1, 10));
		list3.add(new Tables(2, 2));
		list3.add(new Tables(3, 6));
		list3.add(new Tables(4, 15));
		return list1;
		
	}
	public List<Tables> getList3() {
		return list3;
	}

	public List<List<Tables>> getListofTables() {
		listOfTables.add(getList1());
		listOfTables.add(getList2());
		listOfTables.add(getList3());
		return listOfTables;
	}
	

	
	////TABLES FOR WAITER VIEW
	public List<Tables>getTablesForWaiterView(){
		
		tablesForWaiterView.add(new Tables("Table #1"));
		tablesForWaiterView.add(new Tables("Table #2"));
		tablesForWaiterView.add(new Tables("Table #3"));
		tablesForWaiterView.add(new Tables("Table #4"));
		tablesForWaiterView.add(new Tables("Table #5"));
		tablesForWaiterView.add(new Tables("Table #6"));
		tablesForWaiterView.add(new Tables("Table #7"));
		tablesForWaiterView.add(new Tables("Table #8"));
		tablesForWaiterView.add(new Tables("Table #9"));
		tablesForWaiterView.add(new Tables("Table #10"));
		
		return tablesForWaiterView;
	}
	
	
}
