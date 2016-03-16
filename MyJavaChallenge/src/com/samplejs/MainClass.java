package com.samplejs;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;



public class MainClass{
	private boolean valid = true;
	private String URI = "jdbc:mysql://localhost:3306/my_test";
	private String USERNAME = "marcot";
	private String PASSWORD = "manu";
public boolean connectionStatus() throws ClassNotFoundException{
	try{
		Class.forName("com.mysql.jdbc.Driver");  
		String mysql = "";
		Connection  connection = DriverManager.getConnection(URI,USERNAME, PASSWORD);
		Statement s = (Statement)connection.createStatement();	
		s.execute("select 1 from dual");
		s.close();
		connection.close();
	}
	catch(SQLException e){
		valid = false;
		System.out.println("Connection is Down");
		//e.printStackTrace();
	}
		return valid;
}

public boolean serverStatus(HttpServletRequest request,HttpServletResponse response){
	boolean status = false;
	//System.out.println(request.getLocalPort());
	try {
		Socket socket = new Socket("127.0.0.1",request.getLocalPort());
		if(socket.isConnected()){
			//System.out.println("yes");
			status = true;
		}
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Server Down");
		//e.printStackTrace();
	}
	return status;
}

}
