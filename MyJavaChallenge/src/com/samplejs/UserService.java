package com.samplejs;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

	public List<Users> listUsers(String type,String country,String prof);
		
	public Users verifyUser(String userEmail,String password);
	public List groubyUsers(String Country);
	
}
