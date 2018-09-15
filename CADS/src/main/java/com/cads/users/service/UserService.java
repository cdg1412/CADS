package com.cads.users.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cads.users.dto.UserDto;

@Service
public class UserService {
	Map<String, String> setOfValidUserCredentials = new HashMap<String,String>();
	Map<String, UserDto> mapUserIDToUser = new HashMap<String,UserDto>();

	public void setListOfValidUserCredentials(Map<String, String> setOfValidUserCredentials) {
		//Remove the dummy data after integrating with db
		setOfValidUserCredentials.put("antara@gmail.com", "antara");
		setOfValidUserCredentials.put("Champak", "Champak");
		setOfValidUserCredentials.put("Debasmita", "Debasmita");
		setOfValidUserCredentials.put("Sourav", "Sourav");
		this.setOfValidUserCredentials = setOfValidUserCredentials;
	}

	public List<UserDto> getAllUsers() {		
		List<UserDto> userList= mapUserIDToUser.values().parallelStream().collect(Collectors.toList());
	    return userList;
	}
	
	public UserDto getSingleUserDetailsByID(String userID) {
		return mapUserIDToUser.get(userID);
	}

	public void createuser(UserDto user) {		
		mapUserIDToUser.put(user.getUserID(), user);
		setOfValidUserCredentials.put(user.getUserName(), user.getPassword());
	}

	public void deleteUser(String userID) {
		setOfValidUserCredentials.remove(mapUserIDToUser.get(userID).getUserName());
		mapUserIDToUser.remove(userID);
		
	}

	public void updateUser(UserDto user) {
		// TODO Auto-generated method stub
		setOfValidUserCredentials.put(user.getUserName(), user.getPassword());
		mapUserIDToUser.put(String.valueOf(user.getUserID()), user);
	}

	public boolean isValidUser(String userName, String password) {		
		return(this.setOfValidUserCredentials.get(userName).equalsIgnoreCase(password));
	}

	public Object getSingleUserDetailForAUser(String userID, String userAttributeName) {

		Class cls = null;
		//cls = Class.forName("com.cads.users.dto.UserDto");
		cls = mapUserIDToUser.get(userID).getClass();
		Object obj = null;
		
			try {
				obj =cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
		
			
		//call the printIt method
		Method method = null;
		try {
			method = cls.getDeclaredMethod("get"
					+ userAttributeName.substring(0, 1).toUpperCase()+userAttributeName.substring(1));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object attributeValue = null;
		try {
			attributeValue = method == null ? null : method.invoke(mapUserIDToUser.get(userID), null);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attributeValue;
	}

	
}
