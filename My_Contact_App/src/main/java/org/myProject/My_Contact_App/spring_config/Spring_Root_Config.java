package org.myProject.My_Contact_App.spring_config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = {"org.myProject.My_Contact_App.DAO", "org.myProject.My_Contact_App.service"})
public class Spring_Root_Config {
	//TODO: Services, DAO, DataSource, Email Sender or some other business layer beans
	
	@Bean
	public BasicDataSource basicDataSource() {
			BasicDataSource ds= new BasicDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/my_contact_app_db");
			ds.setUsername("root");
			ds.setPassword("SakNeu24");
			ds.setMaxTotal(2);
			ds.setInitialSize(1);
			ds.setTestOnBorrow(true);
			ds.setValidationQuery("SELECT 1");
			ds.setDefaultAutoCommit(true);
			return ds;
	}
}
