package org.myProject.My_Contact_App.exception;

public class UserBlockedExcp extends Exception{
	
	//Create user object without error description
	public UserBlockedExcp() {
		
	}
	
	//Create user object with error description
	public UserBlockedExcp(String errDescp) {
		super(errDescp);	
	}
}
