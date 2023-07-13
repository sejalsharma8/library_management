package com.nagarro.library_management.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;


import com.nagarro.library_management.daoImpl.UserDaoImpl;
import com.nagarro.library_management.util.HibernateUtil;
import com.nagarro.library_management.servicesImpl.AuthorServiceImpl;
import com.nagarro.library_management.servicesImpl.BookServiceImpl;
import com.nagarro.library_management.servicesImpl.UserValidatorImpl;

@Configuration
@ComponentScans(value = {
       
        @ComponentScan("com.nagarro.library_management.dao"),
        @ComponentScan("com.nagarro.library_management.services")
})

public class AppConfig {
	@Bean
	public SessionFactory getSessionFactory() {
		return HibernateUtil.openSession();
	}
	
	@Bean
	public UserDaoImpl getUserDao() {
		return new UserDaoImpl();
	}

	@Bean
	public UserValidatorImpl getUserValidator() {
		return new UserValidatorImpl();
	}
	@Bean
	public BookServiceImpl getBooks() {
		return new BookServiceImpl();
	}
	@Bean 
	public AuthorServiceImpl getAuthors() {
		return new AuthorServiceImpl();
	}
}
