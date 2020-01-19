package p1;
import java.io.*;
import java.util.*;
public class Student implements Serializable{
	String name;
	int id;
	int marks;
	Student(String name,int id,int marks)
	{
		this.name=name;
		this.id=id;
		this.marks=marks;
	}
	
	public String toString()
	{
		return this.name+" "+this.id+" "+this.marks;
		
	}
}
 

