package com.sample.webproject.testentity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;  
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.sample.webproject.entity.Employee;
import com.sample.webproject.entity.Office;
import com.sample.webproject.entity.Employee;

public class TestOffice{
	Office o;
	
	@InjectMocks
	Employee e1;
	
	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");  
        e1=new Employee("teja",1200,new Date());
		Employee e2=new Employee("pruthvi",3000,new Date());
		Employee e3=new Employee("abc",8800,new Date());
		o=new Office("Accolite","hyd");
		Set<Employee> employees=new HashSet<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		o.setEmp(employees);		
    }  
    
    @Test
    public void testOffice() throws  Exception
    {
    	assertEquals("Accolite",o.getName());
    	assertEquals(true,o.getEmp().contains(e1));
    	assertEquals("teja",e1.getName());
    	assertEquals(true,o.getEmp().size()>0);
    	
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
