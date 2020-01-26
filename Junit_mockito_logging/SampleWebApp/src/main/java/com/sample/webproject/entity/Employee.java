package com.sample.webproject.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class Employee {
	public Set<Course> getC() {
		return courses;
	}

   public Employee()
   {
	   
   }
	public void setCourses(Set<Course> c) {
		this.courses = c;
	}


	public Date getJoiningdate() {
		return joiningdate;
	}


	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	private String name;
	private int salary;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "date_of_join")
	private Date joiningdate;

	public Employee(String name,int salary,Date joiningdate)
	{
		this.name=name;
		this.salary=salary;
	    this.joiningdate=joiningdate;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	Set<Course> courses=new HashSet<Course>();
}