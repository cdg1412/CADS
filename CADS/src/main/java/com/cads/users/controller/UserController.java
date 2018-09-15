package com.cads.users.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cads.users.dto.UserDto;
import com.cads.users.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class UserController {

@Autowired
private UserService userService;

	@RequestMapping(com.cads.utils.URLConstants.AUTHENTICATE)
	public boolean authenticate(String userName, String password) {
		
	 return userService.isValidUser(userName,password);
	}
	
	@RequestMapping(com.cads.utils.URLConstants.USERURI)
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
		
	}
	
	@RequestMapping(com.cads.utils.URLConstants.USERURI+"/{userID}")
	public UserDto getUser(@PathVariable String userID) {
		return userService.getSingleUserDetailsByID(userID);		
	}
	
	@RequestMapping(com.cads.utils.URLConstants.USERURI+"/{userID}")
	public Object getSingleAttributeForUser(@PathVariable String userID,String userAttributeName) {
		return userService.getSingleUserDetailForAUser(userID,userAttributeName);		
	}
	
	@RequestMapping(method=RequestMethod.POST, value=com.cads.utils.URLConstants.USERURI)
	public void addUser(@RequestBody UserDto user) {
		userService.createuser(user);		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=com.cads.utils.URLConstants.USERURI)
	public void deleteUser(@PathVariable String userID) {
		userService.deleteUser(userID);		
	}
	
	/*
	 * Use this for adding/updating groups/tools and all other properties of user.
	 * The request body has to contain the property to be changed and corresponding new value.
	 */
	@RequestMapping(method=RequestMethod.PUT, value=com.cads.utils.URLConstants.USERURI)
	public void updateUser(@RequestBody UserDto user) {
		userService.updateUser(user);		
	}
	
	
}
