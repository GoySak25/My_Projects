package org.myProject.My_Contact_App.spring_config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Contact_App_Dispatcher_Servlet_Initializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{Spring_Root_Config.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{Spring_Web_Config.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	
	@Override
	public void onStartup(ServletContext context) throws ServletException{
		super.onStartup(context); //must present
		//configure global task if required
	}
	// this class will initialize the front controller
	
//	@Override
//	protected Class<?>[] getRootConfigClasses(){
//		return new Class[] {Spring_Root_Config.class};
//	}
//	
//	@Override
//	protected Class<?>[] getServletConfigClasses(){
//		return new Class[] {Spring_Web_Config.class};
//	}
//	
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] {"/"};
//	}
//
//	@Override
//	public 	void onStartup(ServletContext context) throws ServletException{
//		super.onStartup(context); //must present
//		//configure global task if required
//	}

}
