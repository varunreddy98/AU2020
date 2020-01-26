package com.sample.webproject.testentity;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.sample.webproject.entity.Course;
import com.sample.webproject.log4j.Demo;

@RunWith(MockitoJUnitRunner.class)
public class TestCourse {
	@Mock
	Course c1;
	static final Logger logger = Logger.getLogger(TestCourse.class);  
	
	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  
    @Before  
    public void setUp() throws Exception { 
    	 MockitoAnnotations.initMocks(this);
        System.out.println("before");  
     	c1=new Course("java");
    }  
    
    @Test
    public void testCourse() throws  Exception
    {
    	String name="java";
    	if(c1==null)
    	{
    		logger.warn("null object found");
    	}
    	logger.info("asserting course name");
    	assertEquals(name,c1.getName());
    	verify(c1, times(1)).getName(); 
    	verify(c1, atLeastOnce()).getName(); 
    	verify(c1, atMost(2)).getName();
    	verify(c1, atLeast(1)).getName();
    	verify(c1, never()).getName();
    	
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
