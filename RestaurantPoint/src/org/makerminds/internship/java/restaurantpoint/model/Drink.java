package org.makerminds.internship.java.restaurantpoint.model;

public class Drink extends Products{
	private boolean sugarFree;
	public Drink(String name, int productId, double price) {
		super(name, productId, price);
		// TODO Auto-generated constructor stub
	}
	
	public Drink(String name, int productId, double price,boolean sugarfree) {
		super(name, productId, price);
		// TODO Auto-generated constructor stub
		//this.sugarFree=sugarFree;
	
	}

	public boolean getSugarFree() {
		return sugarFree;
	}

	public void setSugarFree(boolean sugarFree) {
		this.sugarFree = sugarFree;
	}
	
}
