package org.myProject.My_Contact_App.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//NOTE: do not use @Repository or @Service or @Component annotation
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{
	@Autowired
	public void setDatasource(DataSource ds) {
		super.setDataSource(ds);
	}
}
