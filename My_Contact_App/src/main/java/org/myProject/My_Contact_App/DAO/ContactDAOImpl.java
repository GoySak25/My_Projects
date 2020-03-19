package org.myProject.My_Contact_App.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myProject.My_Contact_App.entity.Contact;
import org.myProject.My_Contact_App.row_mapper.ContactRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAOInterface{

	@Override
	public void save(Contact con) {
		// TODO Auto-generated method stub
		String sql= "INSERT INTO contact(userID, name, phone, email, address, remark)"
		+"VALUES(:userID, :name, :phone, :email, :address, :remark)"; //Named parameters
		Map map= new HashMap();
		map.put("userID", con.getUserID());
		map.put("name", con.getName());
		map.put("phone", con.getPhone());
		map.put("email", con.getEmail());
		map.put("address", con.getAddress());
		map.put("remark", con.getRemark());
		SqlParameterSource ps= new MapSqlParameterSource(map);
		KeyHolder keyholder= new GeneratedKeyHolder();
		
		getNamedParameterJdbcTemplate().update(sql, ps, keyholder);
		Integer contactID= keyholder.getKey().intValue();
		con.setContactID(contactID);
	}

	@Override
	public void update(Contact con) {
		// TODO Auto-generated method stub
		String sql= "UPDATE contact SET name=:name, phone=:phone, email=:email, address=:address, remark=:remark WHERE contactID=:contactID";
		Map map= new HashMap();
		map.put("contactID", con.getContactID());
		map.put("name", con.getName());
		map.put("phone", con.getPhone());
		map.put("email", con.getEmail());
		map.put("address", con.getAddress());
		map.put("remark", con.getRemark());
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public void delete(Contact con) {
		// TODO Auto-generated method stub
		this.delete(con.getContactID());
	}

	@Override
	public void delete(Integer contactID) {
		// TODO Auto-generated method stub
		String sql= "DELETE FROM contact WHERE contactID=?";
		getJdbcTemplate().update(sql, contactID);
	}

	@Override
	public Contact findByID(Integer contactID) {
		// TODO Auto-generated method stub
		String sql= "SELECT contactID, userID, name, phone, email, address, remark"+
		" FROM contact WHERE contactID=?";
		Contact con= getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactID);
		return con;
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		String sql= "SELECT contactID, userID, name, phone, email, address, remark"+
				"FROM contact WHERE contactID=?";
		List<Contact> listContact=getJdbcTemplate().query(sql, new ContactRowMapper());
		
		return listContact;
	}

	@Override
	public List<Contact> findByProperty(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		String sql= "SELECT contactID, userID, name, phone, email, address, remark"+
				" FROM contact WHERE "+ propertyName+ "=?";
		List<Contact> list= getJdbcTemplate().query(sql, new ContactRowMapper(), propertyValue);
		return list;
	}

}
