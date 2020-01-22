package com.accolite.web.models;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
//@Entity
//@Table(name = "users")
//@JacksonXmlRootElement(localName = "User")
public class User implements Serializable{
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//@JacksonXmlProperty
	private int id;
	
	// @JacksonXmlProperty
	private String name;
	 
	// @JacksonXmlProperty
	private int age;
	
	 
	 @Override
	    public String toString() {
	        return "User{" + "id=" + id + ", name=" + name
	                + ", age=" + age + '}';
	    }

	    @Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 37 * hash + Objects.hashCode(this.id);
	        hash = 37 * hash + Objects.hashCode(this.name);
	        hash = 37 * hash + this.age;
	        return hash;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final User other = (User) obj;
	        if (this.age != other.age) {
	            return false;
	        }
	        if (!Objects.equals(this.name, other.name)) {
	            return false;
	        }

	        return Objects.equals(this.id, other.id);
	    }
}
