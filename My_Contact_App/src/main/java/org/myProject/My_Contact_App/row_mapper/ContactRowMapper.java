package org.myProject.My_Contact_App.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.myProject.My_Contact_App.entity.Contact;
import org.springframework.jdbc.core.RowMapper;

public class ContactRowMapper implements RowMapper<Contact>{
	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Contact con= new Contact();
		con.setContactID(rs.getInt("contactID"));
		con.setUserID(rs.getInt("userID"));
		con.setName(rs.getString("name"));
		con.setPhone(rs.getString("phone"));
		con.setAddress(rs.getString("address"));
		con.setEmail(rs.getString("email"));
		con.setRemark(rs.getString("remark"));
		return con;
	}
}
