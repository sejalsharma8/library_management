package com.nagarro.library_management.services;

import org.springframework.stereotype.Service;

import com.nagarro.library_management.exceptions.HibernateDBException;
import com.nagarro.library_management.model.User;

@Service
public interface UserValidator {
	User userNotExist(String username) throws HibernateDBException;
	 void passwordMismatch(String password, String Password) throws HibernateDBException;
}
