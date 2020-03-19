package org.myProject.My_Contact_App.controller;

import javax.servlet.http.HttpSession;

import org.myProject.My_Contact_App.command.LoginCommand;
import org.myProject.My_Contact_App.command.RegistrationCommand;
import org.myProject.My_Contact_App.entity.User;
import org.myProject.My_Contact_App.exception.UserBlockedExcp;
import org.myProject.My_Contact_App.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@RequestMapping(value= {"/", "/indexUser"})
	public String  index(ModelMap model) {
		model.addAttribute("command", new LoginCommand());
		return "indexUser"; //JSP- /WEB_INF/views/index.jsp
	}
	
	@RequestMapping(value= "/login", method=RequestMethod.POST)
	public String  handleLogin(@ModelAttribute("command") LoginCommand comm, ModelMap model, HttpSession session) {
		try {
			User user= userServiceInterface.userLogin(comm.getLoginName(), comm.getPassword());
			if(user==null) {
				model.addAttribute("err", "Login failed! Please try again!!");
				return "indexUser";
			}
			else {
				if(user.getRole().equals(userServiceInterface.ROLE_ADMIN)) {
					addUserInSession(user, session);
					return "redirect:admin/dashboard";
				}
				else if(user.getRole().equals(userServiceInterface.ROLE_USER)){
					addUserInSession(user, session);
					return "redirect:user/dashboard";
				}
				else {
					model.addAttribute("err", "No such role exist. Please enter correct role!!");
					return "indexUser";
				}
			}
			
		} catch (UserBlockedExcp e) {
			// TODO Auto-generated catch block
			//add the error message and go back to login form
			model.addAttribute("err", e.getMessage());
			return "indexUser"; //JSP- Login form
		}
	}
	
	@RequestMapping(value= "/registration_form")
	public String registerationForm(Model model) {
		RegistrationCommand reg= new RegistrationCommand();
		model.addAttribute("command", reg);
		return "registration_form";
	}
	
	@RequestMapping(value= "/register")
	public String registerUser(@ModelAttribute("command") RegistrationCommand cmd, Model model) {
		try {
			User user= cmd.getUser();
			user.setRole(userServiceInterface.ROLE_USER);
			user.setLogin_status(userServiceInterface.LOGIN_STATUS_ACTIVE);
			userServiceInterface.userRegister(user);
			return "redirect:indexUser?action=registration";
		}
		catch(DuplicateKeyException exp) {
			model.addAttribute("err_message", "Username is already registered. Please try another username.");
			return "registration_form";
		}
	}
	
	@RequestMapping(value= "/logout")
	public String  logout(HttpSession session) {
		session.invalidate();
		return "redirect:indexUser?action=logout";
	}
	
	@RequestMapping(value= "/user/dashboard")
	public String  userDashBoard() {
		return "userDashboard"; //JSP- /WEB_INF/views/userDashboard.jsp
	}
	
	@RequestMapping(value= "/admin/dashboard")
	public String  adminDashBoard() {
		return "adminDashboard"; //JSP- /WEB_INF/views/adminDashboard.jsp
	}
	
	@RequestMapping(value= "/admin/users")
	public String  showUserList(Model model) {
		model.addAttribute("userList", userServiceInterface.userList());
		return "userList"; //JSP- /WEB_INF/views/adminDashboard.jsp
	}
	
	@RequestMapping(value="/admin/changeStatus")
	@ResponseBody
	public String  changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus) {
		try {
			userServiceInterface.changeUserStatus(userId, loginStatus);
			return "SUCCESS: Status Changed";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "ERROR: Unable to Change Status";
		}
	}
	
	@RequestMapping(value= "/checkAvail")
	@ResponseBody
	public String  check_availability(@RequestParam String usName ) {
		try {
			if(userServiceInterface.isUserNameExists(usName)) {
				return "This user name is already taken. Choose another name!";
			}
			return "This user name is available";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "";
		}	
	}
	
	private void addUserInSession(User user, HttpSession session) {
		session.setAttribute("user", user);
		session.setAttribute("userId", user.getUserID());
		session.setAttribute("role", user.getRole());
	}
	
	
}
