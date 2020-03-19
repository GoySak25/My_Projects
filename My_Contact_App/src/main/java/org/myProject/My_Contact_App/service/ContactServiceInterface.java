package org.myProject.My_Contact_App.service;

import java.util.List;

import org.myProject.My_Contact_App.entity.Contact;

//THe interface specifies for the business operation regarding contact entity
public interface ContactServiceInterface {
	public void saveContact(Contact con);
	public void updateContact(Contact con);
	public void deleteContact(Integer contactID);
	public void deleteContacts(Integer[] contactIDs);
	public Contact findByID(Integer contactID);
	public List<Contact> findUserContact(Integer userID);// Will return all the contacts of the user who is logged in
	public List<Contact> findUserContact(Integer userID, String txt);// the method will search for the user(userID) based on free text criteria
	
}
