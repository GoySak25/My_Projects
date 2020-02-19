package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Files;
public class FilesDAO {
	SessionFactory factory= new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Files.class)
			.buildSessionFactory();
	public void addFilesDetails(Files file) {
		Session session= factory.getCurrentSession();//This is not servlet session rather it is an database session
		session.beginTransaction();
		session.save(file);
		session.getTransaction().commit();
		System.out.println(file.getFileName()+ " got added");
	}
	public List<Files> getFiles(){
		Session session= factory.getCurrentSession();
		session.beginTransaction();
		List<Files> list= session.createQuery("from files").getResultList();
		return list;
		
	}
	public void update(int id, String caption, String label) {
		// TODO Auto-generated method stub
		Session session= factory.getCurrentSession();//This is not servlet session rather it is an database session
		session.beginTransaction();
		Files file= session.get(Files.class, id);
		file.setCaption(caption);
		file.setLabel(label);
		session.getTransaction().commit();
		System.out.println(file.getFileName()+ " got updated");
	}
	public Files view(int id) {
		// TODO Auto-generated method stub
		Session session= factory.getCurrentSession();//This is not servlet session rather it is an database session
		session.beginTransaction();
		Files file= session.get(Files.class, id);
		session.getTransaction().commit();
		return file;
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session= factory.getCurrentSession();//This is not servlet session rather it is an database session
		session.beginTransaction();
		Files file= session.get(Files.class, id);
		session.delete(file);
		session.getTransaction().commit();
	}
	
}
