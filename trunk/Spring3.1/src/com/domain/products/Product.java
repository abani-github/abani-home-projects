package com.domain.products;

public class Product {

	private String brand;
	private int id;
	private String type;

	public Product(int id, String type, String brand) {
		this.id = id;
		this.type = type;
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ brand - ").append(this.brand)
		.append(" :: ").append("type - ").append(this.type)
		.append(" ]");
		return sb.toString();
	}
}
