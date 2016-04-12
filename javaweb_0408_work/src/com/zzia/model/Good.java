package com.zzia.model;

public class Good {
	private String name;
	private int count;
	private double price;
	public Good() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Good(String name, int count, double price) {
		super();
		this.name = name;
		this.count = count;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Good [name=" + name + ", count=" + count + ", price=" + price
				+ "]";
	}
	
}
