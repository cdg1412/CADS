package com.cads.usergroup.dto;

import java.util.List;
import java.util.Map;

public class UserGroupDto {
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public List<String> getAssociatedUsers() {
		return associatedUsers;
	}
	public void setAssociatedUsers(List<String> associatedUsers) {
		this.associatedUsers = associatedUsers;
	}
	public Map<String, String> getAssociatedToolsWithAccessRights() {
		return associatedToolsWithAccessRights;
	}
	public void setAssociatedToolsWithAccessRights(Map<String, String> associatedToolsWithAccessRights) {
		this.associatedToolsWithAccessRights = associatedToolsWithAccessRights;
	}
	private String groupName;
	private String groupID;
	private List<String> associatedUsers;
	private Map<String,String> associatedToolsWithAccessRights;
	
}
