package com.accolite.web.models;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;

//@JacksonXmlRootElement
public class Users implements Serializable{
	//private static final long serialVersionUID = 22L;
	
//    @JacksonXmlProperty(localName = "User")
//    @JacksonXmlElementWrapper(useWrapping = false)
	ArrayList<User> users=new ArrayList();
	
	public void add(User u)
	{
		users.add(u);
	}
	

	
	
	public ArrayList<User> getUsers()
	{
		return users;
	}

}
