package com.nagarro.library_management.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.library_management.exceptions.HibernateDBException;
import com.nagarro.library_management.model.User;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class UserDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	public User getUserByUsername(String username) throws HibernateDBException {
		Session session=sessionFactory.openSession();

		//used for fetching data based on some criteria
		CriteriaBuilder cb=session.getCriteriaBuilder();
		//specify which entity object you want to use
		CriteriaQuery<User> cq=cb.createQuery(User.class);
		
		//here select * from user statement stored in root
		Root<User> root=cq.from(User.class);
		
		//here we specify something like where username="<argument username>"
		Predicate usernamePredicate=cb.equal(root.get("userName"), username);
		
		//adding query in whole
		cq.select(root).where(usernamePredicate);
		
		//storing result
		User user=null;
		
		try {
			Query query=session.createQuery(cq);
			user=(User) query.getSingleResult();	
		}catch (NoResultException e) {
			return user;
		}
		catch(Exception e) {
			throw new HibernateDBException("Failed to fetch user for vaildating username!!");
		}
		
		session.close();
		
		return user;
	}
}
