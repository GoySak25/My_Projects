package org.myProject.My_Contact_App.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.myProject.My_Contact_App.DAO.BaseDAO;
import org.myProject.My_Contact_App.DAO.UserDAOInterface;
import org.myProject.My_Contact_App.entity.User;
import org.myProject.My_Contact_App.exception.UserBlockedExcp;
import org.myProject.My_Contact_App.row_mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

//we are extending basedao so that we get database support

@Service
public class UserServiceImpl extends BaseDAO implements UserServiceInterface{
	
	@Autowired
	private UserDAOInterface userDao;
	
	@Override
	public void userRegister(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public User userLogin(String loginName, String password) throws UserBlockedExcp {
		// TODO Auto-generated method stub
		String sql= "SELECT userID, user_name, phone_number, email_address, login_mane, role, login_status"+
				" FROM user WHERE login_mane=:ln AND password=:pass";
		Map map= new HashMap();
		map.put("ln", loginName);
		map.put("pass", password);
		try {
			User user=getNamedParameterJdbcTemplate().queryForObject(sql, map, new UserRowMapper());
			if(user.getLogin_status().equals(LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedExcp("Sorry, the account has been blocked!!");
			}
			else {
				return user;
			}
		}
		catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return userDao.findByProperty("role", UserServiceInterface.ROLE_USER);
	}

	@Override
	public void changeUserStatus(Integer userID, Integer loginStatus) {
		// TODO Auto-generated method stub
		String sql= "UPDATE user SET login_status=:loginStatus WHERE userID=:id";
		Map map= new HashMap();
		map.put("id", userID);
		map.put("loginStatus", loginStatus);
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public boolean isUserNameExists(String userName) {
		// TODO Auto-generated method stub
		String sql= "SELECT count(login_mane) FROM user WHERE user_name=?";
		Integer count=getJdbcTemplate().queryForObject(sql, new String[]{userName}, Integer.class);
		if(count==1) {
			return true;
		}
		return false;
	}

}
