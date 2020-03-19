package org.myProject.My_Contact_App.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myProject.My_Contact_App.entity.User;
import org.myProject.My_Contact_App.row_mapper.UserRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

//class communicating with the database must be annotated @Repository
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAOInterface{

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		String sql= "INSERT INTO user(user_name, phone_number, email_address, login_mane, password, role, login_status)"
		+"VALUES(:user_name, :phone_number, :email_address, :login_mane, :password, :role, :login_status)"; //Named parameters
		Map map= new HashMap();
		map.put("user_name", user.getUser_name());
		map.put("phone_number", user.getPhone_number());
		map.put("email_address", user.getEmail_address());
		map.put("login_mane", user.getLogin_mane());
		map.put("password", user.getPassword());
		map.put("role", user.getRole());
		map.put("login_status", user.getLogin_status());
		KeyHolder keyholder= new GeneratedKeyHolder();
		SqlParameterSource ps= new MapSqlParameterSource(map);
		super.getNamedParameterJdbcTemplate().update(sql, ps, keyholder);
		Integer userID= keyholder.getKey().intValue();
		user.setUserID(userID);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql= "UPDATE user"
		+ "SET user_name:=user_name, phone_number:=phone_number, email_address:=email_address, login_mane:=login_mane, password:=password, role:=role, login_status:=login_status"
		+ "WHERER userID:=userID";
		Map map= new HashMap();
		map.put("user_name", user.getUser_name());
		map.put("phone_number", user.getPhone_number());
		map.put("email_address", user.getEmail_address());
		map.put("role", user.getRole());
		map.put("login_status", user.getLogin_status());
		map.put("userID", user.getUserID());
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		this.delete(user.getUserID());
	}

	@Override
	public void delete(Integer userID) {
		// TODO Auto-generated method stub
		String sql= "DELETE FROM user WHERE userID=?";
		getJdbcTemplate().update(sql, userID);
	}

	@Override
	public User findByID(Integer userID) {
		// TODO Auto-generated method stub
		String sql= "SELECT userID, user_name, phone_number, email_address, login_mane, role, login_status "+
		"FROM user WHERE userID=?";
		User u= getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userID);
		return u;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql= "SELECT userID, user_name, phone_number, email_address, login_mane, role, login_status"+
				"FROM user";
		List<User> listUser=getJdbcTemplate().query(sql, new UserRowMapper());
		
		return listUser;
	}

	@Override
	public List<User> findByProperty(String propertyName, Object propertyValue) {
		// TODO Auto-generated method stub
		String sql= "SELECT userID, user_name, phone_number, email_address, login_mane, role, login_status"+
				" FROM user WHERE " + propertyName+ "=?";
		List<User> list= getJdbcTemplate().query(sql, new UserRowMapper(), propertyValue);
		return list;
	}
}
