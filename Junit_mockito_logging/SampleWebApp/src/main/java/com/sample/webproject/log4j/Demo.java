package com.sample.webproject.log4j;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.webproject.entity.Employee;
 
public class Demo {
 
	static Employee e=null;
    static final Logger logger = Logger.getLogger(Demo.class);  
     
    public static void main(String a[]){
         
        logger.info("creating the employee object");
        if(e==null)
        {
        	logger.fatal("null object");
        	logger.warn("warning");
        }
        e=new Employee("abc",6666,new Date());
        if(e!=null)
        {
        	logger.info("correct");
        }
       logger.info("printing the name of employee");
        System.out.println(e.getName());
        
        logger.info("done...");
    }
}