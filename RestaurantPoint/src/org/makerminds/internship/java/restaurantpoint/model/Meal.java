package org.makerminds.internship.java.restaurantpoint.model;

public class Meal extends Products {
	private String description;

	public Meal(String name, int productId, double price) {
		super(name, productId, price);
	}

	public Meal(String name, int productId, double price,String description) {
		super(name, productId, price);
		this.description=description;

	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	}
