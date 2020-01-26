package com.sample.webproject.session;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sample.webproject.entity.Course;
import com.sample.webproject.entity.Employee;
import com.sample.webproject.entity.Office;
import com.sample.webproject.entity.OutsideCourse;
import com.sample.webproject.entity.SpecialCourse;
import com.sample.webproject.log4j.Demo;

import antlr.collections.List;

public class CreateEmployeeDemo {
	
	static SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static Session session=sessionFactory.openSession();
	 static final Logger logger = Logger.getLogger(CreateEmployeeDemo.class); 
	
	public static void main(String[] args) {
		session.beginTransaction();
		Office o=new Office("ABC","blr");
		if(o==null)
		{
			logger.warn("warning");
		}
		else
		{
			logger.info("safe");
		}
		session.save(o);
		Employee e1=new Employee("teja",1200,new Date());
		session.save(e1);
		Employee e2=new Employee("pruthvi",3000,new Date());
		session.save(e2);
		Employee e3=new Employee("abc",8800,new Date());
		session.save(e3);
		Course c1=new Course("c");
		OutsideCourse c2=new OutsideCourse("java","alfred",600);
		SpecialCourse c3=new SpecialCourse("python","notes");
		session.save(c1);
		session.save(c2);
		session.save(c3);
		Set<Course> courses=new HashSet<Course>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		e1.setCourses(courses);
		e2.setCourses(courses);
		OutsideCourse c5=new OutsideCourse("nodejs","krish",1000);
		SpecialCourse c6=new SpecialCourse("html","notes22");
		session.save(c1);
		session.save(c5);
		session.save(c6);
		Set<Course> courses1=new HashSet<Course>();
		courses.add(c2);
		courses.add(c5);
		courses.add(c6);
		e3.setCourses(courses);
		Set<Employee> employees=new HashSet<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		o.setEmp(employees);
		session.getTransaction().commit();
		session.close();
		session=sessionFactory.openSession();
		session.beginTransaction();
		 Query query=session.createQuery("from Office");
		 java.util.List<Office> list=query.getResultList();
		  System.out.println("helloo");
		  System.out.println(list.size());
		  if(list==null)
		  {
			  logger.error("error from db");
		  }
		  for(Office rs:list)
		  {
			  System.out.println(rs);
			  
		  }
		 
		  session.getTransaction().commit();
		  session.close();
	
	}

}
