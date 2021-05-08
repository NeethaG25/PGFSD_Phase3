package com.simplilearn.neetha.model;

public class CreateProductRequestVO {
	
	private int id;
	private String brand;
	private String colour;
	private String category;
	private Double shoeSize;
	private Double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(Double shoeSize) {
		this.shoeSize = shoeSize;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CreateProductVO [id=" + id + ", brand=" + brand + ", colour=" + colour + ", category=" + category
				+ ", shoeSize=" + shoeSize + ", price=" + price + "]";
	}
	
	

}
