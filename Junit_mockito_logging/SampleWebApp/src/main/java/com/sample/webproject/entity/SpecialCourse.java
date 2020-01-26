package com.sample.webproject.entity;

import javax.persistence.Entity;

@Entity
public class SpecialCourse extends Course{
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	String notes;
	
	public SpecialCourse(String name,String notes)
	{
		this.notes=notes;
		this.name=name;
	}

	
	public SpecialCourse()
	{
		
	}
}
