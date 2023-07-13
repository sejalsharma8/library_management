package com.nagarro.library_management.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

import com.nagarro.library_management.constants.Constant;
import com.nagarro.library_management.model.User;


public class HibernateUtil {
	public static List<User> UserList =new ArrayList<User>();
	public static SessionFactory openSession() {
		return new  org.hibernate.cfg.Configuration()
				.setProperties(hibernateProperties())
				.addAnnotatedClass(User.class)
				.buildSessionFactory();	
	}
	
	private static Properties hibernateProperties() {
		Properties properties=new Properties();
		//properties.setProperty(Environment.DRIVER, Constant.HIBERNATE_DRIVER);
		properties.setProperty(Environment.DIALECT, Constant.HIBERNATE_DIALECT);
		properties.setProperty(Environment.URL, Constant.HIBERNATE_URL);
		properties.setProperty(Environment.USER, Constant.HIBERNATE_USERNAME);
		properties.setProperty(Environment.PASS, Constant.HIBERNATE_PASSWORD);
		properties.setProperty(Environment.HBM2DDL_AUTO, Constant.HIBERNATE_HBM2DDL_AUTO);
		properties.setProperty(Environment.SHOW_SQL,Constant.HIBERNATE_SHOW_SQL);
		return properties;
	}
}
