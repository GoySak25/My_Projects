package org.myProject.My_Contact_App.service;

import java.util.List;

import org.myProject.My_Contact_App.entity.User;
import org.myProject.My_Contact_App.exception.UserBlockedExcp;

public interface UserServiceInterface {
	public static final Integer LOGIN_STATUS_ACTIVE=1;
	public static final Integer LOGIN_STATUS_BLOCKED=2;
	public static final Integer ROLE_ADMIN=1;
	public static final Integer ROLE_USER=2;
	
	public void userRegister(User user);
	
	//User login, this method is authentication method which takes loginName and password as parameter and return User if user exists otherwise return null
	//and will throw user blocked exception if the user account is blocked
	public User userLogin(String loginName, String password) throws UserBlockedExcp;
	
	//Call this method to see the list of registered users
	public List<User> userList();
	
	//This method is to chage the status of user to active or blocked, 1 states for active and 2  for bloked
	public void changeUserStatus(Integer userID, Integer loginStatus);
	
	public boolean isUserNameExists(String userName);
}
