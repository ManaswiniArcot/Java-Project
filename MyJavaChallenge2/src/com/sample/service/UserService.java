package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import com.sample.Dao.Users;

public interface UserService {

	public List<Users> listUsers(String type,String country,String prof);
		
	public Users verifyUser(String userEmail,String password);
	public List groubyUsers(String Country);
	
}
