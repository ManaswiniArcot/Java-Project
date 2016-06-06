package com.sample.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public interface UserDao {  
	public List<Users> listAllUsers(String type,String Country,String Prof);
	    
	public Users verifyUser(String userEmail,String password);
	
	public List groubyUsers(String Country);
	
	
}
