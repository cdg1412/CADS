package com.cads.usergroup.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cads.usergroup.dto.UserGroupDto;
import com.cads.usergroup.service.UserGroupService;
import com.cads.users.dto.UserDto;
import com.cads.users.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@Controller
public class UserGroupController {

@Autowired
private UserGroupService userGroupService;

    @RequestMapping(com.cads.utils.URLConstants.USERGROUPURI)
	public List<UserDto> getAllGroups() {
		return userGroupService.getAllGroups();
		
	}
	
	@RequestMapping(com.cads.utils.URLConstants.USERGROUPURI+"/{userID}")
	public UserDto getUserGroup(@PathVariable String userID) {
		return userGroupService.getSingleUserGroupDetailsByID(userID);		
	}
	
	@RequestMapping(method=RequestMethod.POST, value=com.cads.utils.URLConstants.USERGROUPURI)
	public void addUserGroup(@RequestBody UserGroupDto user) {
		userGroupService.createuserGroup(user);		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=com.cads.utils.URLConstants.USERGROUPURI)
	public void deleteUserGroup(@PathVariable String groupID) {
		userGroupService.deleteUserGroup(groupID);		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value=com.cads.utils.URLConstants.USERGROUPURI)
	public void updateUserGroup(@RequestBody UserGroupDto group) {
		userGroupService.updateGroup(group);		
	}
	
	
}
