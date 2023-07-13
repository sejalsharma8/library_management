package com.nagarro.library_management.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.library_management.daoImpl.UserDaoImpl;
import com.nagarro.library_management.exceptions.HibernateDBException;
import com.nagarro.library_management.model.User;
import com.nagarro.library_management.services.UserValidator;

public class UserValidatorImpl implements UserValidator{

	@Autowired
	private UserDaoImpl userDao;

	public User userNotExist(String username) throws HibernateDBException {
		User user = userDao.getUserByUsername(username);
		if (user == null) {
			throw new HibernateDBException("Account does not Exist!!");
		}
		return user;
	}
	
	public static boolean checkPassword(String typed, String savedPassword) {
		return typed.equals(savedPassword);
	}
	
	public void passwordMismatch(String password, String Password) throws HibernateDBException {
		if (!checkPassword(password, Password))
			throw new HibernateDBException("Invalid Credentials!!");
	}

}
