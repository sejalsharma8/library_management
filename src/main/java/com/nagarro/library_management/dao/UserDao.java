package com.nagarro.library_management.dao;

import com.nagarro.library_management.exceptions.HibernateDBException;
import com.nagarro.library_management.model.User;

public interface UserDao {
	public User getUserByUsername(String username) throws HibernateDBException ;
}
