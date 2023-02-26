package org.makerminds.internship.java.restaurantpoint.model;

public class Products {
	@Override
	public String toString() {
		return  name + productId + price;
	}
	private String name;
	private int productId;
	private double quantity;
	private double price;
	
	


	public Products(String name, double quantity, double price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	

}
