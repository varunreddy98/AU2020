package com.sample.webproject.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Office {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set<Employee> getEmp() {
		return emp;
	}
	public void setEmp(Set<Employee> emp) {
		this.emp = emp;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String city;

	 public Office(String name,String city)
	 {
		 this.name=name;
		 this.city=city;
	 }
	 
	 public Office()
	 {
		 
	 }
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Employee> emp=new HashSet<Employee>();

	public String toString()    
	{
		String st="";
		st+="office:"+name+"\n"+"city:"+city+"\n"+" employees:"+"\n";
		for(Employee e:emp)
		{  DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");    
			st+="name:"+e.getName()+" "+" salary:"+e.getSalary()+" joiningdate:"+dateFormat.format(e.getJoiningdate())+" courses:";
			for(Course c:e.getC())
			{
				st+=c.getName()+" ";
			}
		}
		return st;
	}

}
