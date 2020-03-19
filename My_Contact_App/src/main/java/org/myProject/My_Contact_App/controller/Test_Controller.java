package org.myProject.My_Contact_App.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test_Controller {
	@RequestMapping(value = "/test/hello")
	public String helloWorld() {
		return "hello"; //-> /WEB-INF/views/hello.jsp
	}
}
