package com.sample.webproject.testentity;

import java.util.Date;
import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.sample.webproject.entity.Employee;
import com.sample.webproject.log4j.Demo;
import com.sample.webproject.entity.Employee;

public class TestEmployee {
	Employee e1;
	 static final Logger logger = Logger.getLogger(TestEmployee.class); 
	 
	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");  
     	e1=new Employee("varun",4000,new Date());
    }  
    
    @Test
    public void testEmployee() throws  Exception
    {   logger.info("asserting equals");
    	assertEquals("varun",e1.getName());
    	assertEquals(4000,e1.getSalary());
    }
    
    @After  
    public void tearDown() throws Exception {  
        System.out.println("after");  
    }  
  
    @AfterClass  
    public static void tearDownAfterClass() throws Exception {  
        System.out.println("after class");  
    }  
}
