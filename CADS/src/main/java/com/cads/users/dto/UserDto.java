package com.cads.users.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDto {

	private String userName="";
	private String password="";
	private String userID="";
	private String dateOfBirth="";
	private String userGroup="";
	private Map<String,String> visitorsAndParkingSlots=new HashMap<String,String> ();
	private Map<String,Boolean>paymentsStatus=new HashMap<String,Boolean> ();
	private Map<String,String>  permittedToolsWithAccessRights=new HashMap<String,String> ();
    private List<String> buildings =new ArrayList<String>();
    
    private String lastVisitedBuilding ="";
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public Map getVisitorsAndParkingSlots() {
		return visitorsAndParkingSlots;
	}
	public void setVisitorsAndParkingSlots(Map visitorsAndParkingSlots) {
		this.visitorsAndParkingSlots = visitorsAndParkingSlots;
	}
	public Map getPaymentsStatus() {
		return paymentsStatus;
	}
	public void setPaymentsStatus(Map paymentsStatus) {
		this.paymentsStatus = paymentsStatus;
	}
	public Map getPermittedToolsWithAccessRights() {
		return permittedToolsWithAccessRights;
	}
	public void setPermittedToolsWithAccessRights(Map permittedToolsWithAccessRights) {
		this.permittedToolsWithAccessRights = permittedToolsWithAccessRights;
	}
	public String getPassword() {		
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the buildings
	 */
	public List<String> getBuildings() {
		return buildings;
	}
	/**
	 * @param buildings the buildings to set
	 */
	public void setBuildings(List<String> buildings) {
		this.buildings = buildings;
	}
	/**
	 * @return the lastVisitedBuilding
	 */
	public String getLastVisitedBuilding() {
		return lastVisitedBuilding;
	}
	/**
	 * @param lastVisitedBuilding the lastVisitedBuilding to set
	 */
	public void setLastVisitedBuilding(String lastVisitedBuilding) {
		this.lastVisitedBuilding = lastVisitedBuilding;
	}
	
}
