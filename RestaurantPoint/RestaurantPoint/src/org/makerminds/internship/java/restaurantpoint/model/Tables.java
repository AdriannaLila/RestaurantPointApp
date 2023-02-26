package org.makerminds.internship.java.restaurantpoint.model;

public class Tables {
	private int tableId;
	private int tableCapacity;
	private String name;
	

	public Tables(String name) {
		//super();
		this.name = name;
	}

	public Tables(int tableNumber, int tableCapacity) {
		this.tableId = tableNumber;
		this.tableCapacity = tableCapacity;
	}

	public int getTableNumber() {
		return tableId;
	}

	public void setTableNumber(int tableNumber) {
		this.tableId = tableNumber;
	}

	public int getTableCapacity() {
		return tableCapacity;
	}

	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
