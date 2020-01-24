package com.sample.webproject.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "menuitem")
public class MenuItem{
	private String name;
	private double price;
	private int id;
	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return id + " " + name + " " +price+" "+quantity ;
	}

}