package org.myProject.My_Contact_App.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.myProject.My_Contact_App.entity.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user= new User();
		user.setUserID(rs.getInt("userID"));
		user.setUser_name(rs.getString("user_name"));
		user.setPhone_number(rs.getString("phone_number"));
		user.setEmail_address(rs.getString("email_address"));
		user.setLogin_mane(rs.getString("login_mane"));
		//user.setPassword(rs.getString("password"));
		user.setRole(rs.getInt("role"));
		user.setLogin_status(rs.getInt("login_status"));
		return user;
	}

}
