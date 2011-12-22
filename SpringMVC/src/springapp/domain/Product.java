package springapp.domain;

import java.io.Serializable;


public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
	private Double price;

	public Product(){
		
	}
	public Product(String description, Double price) {
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Description: " + description + ";");
		buffer.append("Price: " + price);
		return buffer.toString();
	}
}
