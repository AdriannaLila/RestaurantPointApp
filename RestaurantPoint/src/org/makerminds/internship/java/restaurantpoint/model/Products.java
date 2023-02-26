package org.makerminds.internship.java.restaurantpoint.model;

public class Products {
	private String name;
	private int productId;
	private double price;
	

	public Products(String name,int productId, double price) {
		this.name = name;
		this.productId=productId;
		this.price=price;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
