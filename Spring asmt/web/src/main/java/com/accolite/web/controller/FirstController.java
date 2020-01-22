package com.accolite.web.controller;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import com.accolite.web.models.User;
import com.accolite.web.models.Users;

import org.springframework.web.servlet.ModelAndView;
@Controller
//@SessionAttributes("getUsers")
public class FirstController {
    @Autowired 
    private Users users;
	
	public FirstController()
	{
//		 ApplicationContext ac = new ClassPathXmlApplicationContext("spring-servlet.xml");
//	        Users users= ac.getBean("userid",Users.class);
		
	}
	 @RequestMapping(value="/home")    
	    public @ResponseBody String showindex(){    
	        return "home";   
	    }    
	   
//	@RequestMapping(value="/hi",method=RequestMethod.GET)
//	public @ResponseBody String sayHi() {
//		return "Hello first controller";
//	}
//	
//	@RequestMapping(value="/bye")
//	public @ResponseBody String sayBye() {
//		return "Bye first controller";
//	}
	
//	@RequestMapping(value="/user")
//	public @ResponseBody User getUser() {
//		User user=new User();
//		user.setAge(21);
//		user.setId(1);
//		user.setName("varun");
//		return user;
//	}
//	
	
	   @RequestMapping(value="/userform",method=RequestMethod.GET)    
	    public String showform(Model m){    
	        m.addAttribute("command", new User());  
	        return "userform";   
	    }    
	    
	   @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("user") User user){ 
		   System.out.println(user.getId());
		   users.add(user);
		   for(User u:users.getUsers())
			   System.out.println(u.getName());
	        return "redirect:/viewuser";   
	    }    
	   
	   @RequestMapping(value="/viewuser", method = RequestMethod.GET)    
	    public String viewuser(Model m){    
	        List<User> list=users.getUsers();    
	        m.addAttribute("list",list);  
	        return "viewuser";    
	    }    
//	@RequestMapping(value="/anotheruser",method=RequestMethod.POST)
//	public @ResponseBody User getandSendUser(@RequestBody User user) {
//		return user;
//	}
//	
//	@RequestMapping(value="/employee")
//	public @ResponseBody String getEmployeePage() {
//		return "EmployeeList";
//	}
	
	@RequestMapping("users/{id}")
	  public String getArticle(@PathVariable("id") int id) throws JsonProcessingException {
		   User u=null;
		  
	      for(User u1:users.getUsers()) {
	    	  
	    	  if(u1.getId()==id)
	    	  {
	    		  u=u1;
	    	  }
	    	  
	      }
	      ObjectMapper mapper=new ObjectMapper();
	      String str=mapper.writeValueAsString(u);
		  return str;
	      
	  }
}
