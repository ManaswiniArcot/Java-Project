package com.sample.service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.Dao.UserDao;
import com.sample.Dao.Users;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	 public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<Users> listUsers(String State,String Country,String Prof){
		return userDao.listAllUsers(State, Country, Prof);
	}

	@Override
	public Users verifyUser(String userEmail, String password) {
		// TODO Auto-generated method stub
		return userDao.verifyUser(userEmail, password);
	}

	@Override
	public List groubyUsers(String Country) {
		// TODO Auto-generated method stub
		return userDao.groubyUsers(Country);
	}

	

}
