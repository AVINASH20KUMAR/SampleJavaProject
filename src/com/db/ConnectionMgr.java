package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMgr {
	public static ConnectionMgr instance =null;
	  String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "my_db";
	  String driver = "com.mysql.jdbc.Driver";
	  String userName = "root"; 
	  String password = "";
	  private Connection conn = null;
	  
	  public  static ConnectionMgr getConnection() {
		
		  if(instance==null) {
			  instance = new ConnectionMgr();
		  }
		return instance;
			  
	  }
	  private boolean openConnection() {
		  try {
			  conn = DriverManager.getConnection(url,userName,password);
		  }
		  catch(SQLException e) {
			  e.printStackTrace();
			  
		  }
		  return true;
	  }
	  

}
