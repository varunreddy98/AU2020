package com.sample.webproject.model;
import com.sample.webproject.service.MenuServiceImpl;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "menuitem")
public class MenuItem{
	private String name;
	private double price;
	private int id;
	private int quantity;
	static final Logger logger = Logger.getLogger(MenuItem.class);

	public MenuItem()
	{
		 logger.info("object is created successfully");

	}

	public String getName() {
        if(name==null)
		{
			logger.warn("name is empty");
		}
        else
       		logger.info("returns name"+ name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		if(price<=0)
		{
			logger.warn("price "+price+"  is not valid");
		}
		else
			logger.info("returns price"+ price);
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