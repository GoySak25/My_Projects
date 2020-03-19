package org.myProject.My_Contact_App.DAO;

import java.util.List;

import org.myProject.My_Contact_App.entity.Contact;

public interface ContactDAOInterface {
	public void save(Contact con);
	public void update(Contact con);
	public void delete(Contact con);
	public void delete(Integer contactID);
	public Contact findByID(Integer contactID);
	public List<Contact> findAll();
	public List<Contact> findByProperty(String propertyName, Object propertyValue);
}
