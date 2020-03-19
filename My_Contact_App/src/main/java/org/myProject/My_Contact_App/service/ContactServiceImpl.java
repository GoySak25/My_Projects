package org.myProject.My_Contact_App.service;

import java.util.List;

import org.myProject.My_Contact_App.DAO.BaseDAO;
import org.myProject.My_Contact_App.DAO.ContactDAOInterface;
import org.myProject.My_Contact_App.entity.Contact;
import org.myProject.My_Contact_App.row_mapper.ContactRowMapper;
import org.myProject.My_Contact_App.utility.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactServiceInterface{
	
	@Autowired
	private ContactDAOInterface contactDAO;
	
	@Override
	public void saveContact(Contact con) {
		// TODO Auto-generated method stub
		contactDAO.save(con);
	}

	@Override
	public void updateContact(Contact con) {
		// TODO Auto-generated method stub
		contactDAO.update(con);
	}

	@Override
	public void deleteContact(Integer contactID) {
		// TODO Auto-generated method stub
		contactDAO.delete(contactID);
	}

	@Override
	public void deleteContacts(Integer[] contactIDs) {
		// TODO Auto-generated method stub
		String ids= StringUtility.toCommaSeparatedString(contactIDs);
		String sql= "DELETE FROM contact WHERE contactID IN("+ ids +")";
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer userID) {
		// TODO Auto-generated method stub
		return contactDAO.findByProperty("userID", userID);
	}

	@Override
	public List<Contact> findUserContact(Integer userID, String txt) {
		// TODO Auto-generated method stub
		String sql= "SELECT contactID, userID, name, phone, email, address, remark"+
				" FROM contact WHERE userID=? AND (name LIKE '%"+ txt +"%' OR  phone LIKE '%"+ txt +"%' OR email LIKE '%"+ txt +"%' OR  address LIKE '%"+ txt +"%' OR  remark LIKE '%"+ txt +"%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), userID);
	}

	@Override
	public Contact findByID(Integer contactID) {
		// TODO Auto-generated method stub
		return contactDAO.findByID(contactID);
	}

}
