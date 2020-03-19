package org.myProject.My_Contact_App.DAO;

import java.util.List;

import org.myProject.My_Contact_App.entity.User;

//import org.myProject.My_User_App.entity.User;

public interface UserDAOInterface {
	public void save(User user);
	public void update(User user);
	public void delete(User user);
	public void delete(Integer userID);
	public User findByID(Integer userID);
	public List<User> findAll();
	public List<User> findByProperty(String propertyName, Object propertyValue);
}
