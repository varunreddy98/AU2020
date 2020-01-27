package com.sample.webproject;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.sample.webproject.model.GenericResponse;
import com.sample.webproject.model.MenuItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sample.webproject.service.MenuServiceImpl;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

@RunWith(MockitoJUnitRunner.class)
public class TestMenuServiceImpl {
    @InjectMocks
    MenuServiceImpl service;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("before class");
    }
    @Before
    public void setUp() throws Exception {
        System.out.println("before");
    }

    @Test
    public void TestaddMenuItem()
    {

        MenuItem item=new MenuItem();
        item.setId(1);
        item.setName("abc");
        item.setPrice(3000);
        item.setQuantity(3);
        verify(service, atLeastOnce()).addMenuItem(item);
        Response response=service.addMenuItem(item);
        assertEquals(response.getStatus(), HttpStatus.OK);
        verify(service, times(2)).addMenuItem(item);
    }

    @Test
    public void TestdeleteMenuItem()
    {
        MenuItem item=new MenuItem();
        item.setId(2);
        item.setName("xyz");
        item.setPrice(6000);
        item.setQuantity(1);
        Response response=service.deleteMenuItem(1);
        assertEquals(response.getStatus(), HttpStatus.OK);
        verify(service, atMost(2)).getMenuItem(1);

    }
    @Test
    public void TestgetAllItems() {

        MenuItem menuItem[]=service.getAllMenuItems();
        assertEquals(1,menuItem.length);

    }

    @Test
    public void TestgetSingleItem()
    {
        MenuItem item=service.getMenuItem(2);
        assertEquals("xyz",item.getName());
        assertEquals(600,item.getPrice());
        assertEquals(1,item.getQuantity());
        assertEquals(2,item.getId());
        verify(service, never()).getMenuItem(4);


    }


    @After
    public void Destroy() throws Exception {
        System.out.println("after");
    }

    @AfterClass
    public static void DestroyAfterClass() throws Exception {
        System.out.println("after class");
    }



}
