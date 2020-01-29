package com.accolite.au.web.xmldemo.controller;

import com.accolite.au.web.xmldemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.web.xmldemo.models.User;
import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userService;
	
	@GetMapping(value="user/{tel}",produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserbyName(@PathVariable String tel)
	{
		return userService.getUser(tel);
	}
	
//	@PostMapping(value="sguser",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
//	public User setandGetUser(@RequestBody User user)
//	{
//		return userService.setandGetUserservice(user);
//	}

	@PostMapping(value="adduser",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user)
	{
		System.out.println(user);
		userService.addUserService(user);
	}

	@GetMapping(value = "getAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll()
	{  System.out.println("hello");
        return  (userService.getAll());
	}

	@PostMapping(value="delete/{tel}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable String tel)
	{
		System.out.println(tel);
		userService.deleteUser(tel);
	}


}
