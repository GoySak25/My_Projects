package org.myProject.My_Contact_App.spring_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@ComponentScan(basePackages = {"org.myProject.My_Contact_App"})
@EnableWebMvc

public class Spring_Web_Config extends WebMvcConfigurerAdapter{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry regis) {
		//super.addResourceHandlers(regis);
		//for static resourses like css files, js files muat be added here as spring will not allow us to directly communicate with the jsps
		regis.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr= new InternalResourceViewResolver(); // to excess internal resourse like web-INF as no-one from the browser can directly access the components inside web-INF as web-INF is private location
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/WEB-INF/views/"); // we need to define prefix to give the reference where our jsps are available
		vr.setSuffix(".jsp"); //suffix will the extension of the view
		return vr;
	}
}
