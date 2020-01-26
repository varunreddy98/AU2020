package com.sample.webproject.entity;

import javax.persistence.Entity;

@Entity
public class OutsideCourse extends Course{
	
	public String getPresenter() {
		return presenter;
	}
	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public OutsideCourse(String name,String presenter,int cost)
	{
		this.name=name;
		this.cost=cost;
		this.presenter=presenter;
	}
	public OutsideCourse()
	{
		
	}
	String presenter;
	int cost;

}
