package com.sample.webproject.service;

import javax.ws.rs.core.Response;

import com.sample.webproject.model.MenuItem;

public interface MenuService {

	public Response addMenuItem(MenuItem m);
	
	public MenuItem getMenuItem(int id);
	
	public MenuItem[] getAllMenuItems();
	
	public String getmsg();
	public  Response deleteEmployee(int id);

}