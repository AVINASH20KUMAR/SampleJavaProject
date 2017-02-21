package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.servlets.Persons;

public class NewDB {
	public static List<Persons> users = new ArrayList<Persons>();
	static ResultSet res =null;
	static Connection conn =null;
public NewDB() throws SQLException{
		  String url = "jdbc:mysql://localhost:3306/";
		  String dbName = "my_db";
		  String driver = "com.mysql.jdbc.Driver";
		  String userName = "root"; 
		  String password = "";
		  try {
		  Class.forName(driver).newInstance();
		  conn = DriverManager.getConnection(url+dbName,userName,password);
		  System.out.println("database created successfully");
		  Statement st = (Statement) conn.createStatement(); 
		  res = st.executeQuery("select * from persons");
/*
		  System.out.println("FirstName" +" LastName " +"age ");
		  while (res.next()) {
			  
			  String fname = res.getString("firstName");
			  System.out.print(fname +" ");
			  String Lname = res.getString("lastName");
			  System.out.print(Lname +"  ");
			  int  age = res.getInt("age");
			  System.out.println(age);
			  
			*/  
			  // iterating over the database and getting the result
			 
			//...
			while(res.next())
			    {
			      	Persons  user  = new Persons();	     
			        user.setFirstName(res.getString(1));
			        user.setLastName(res.getString(2));
			        user.setAge(res.getInt(3));			        
			        users.add(user);
			    }
			
	
			  
			  // TO insert values uncomment the following 
			  
//		  int val = st.executeUpdate("INSERT into persons (firstname,lastname,age) VALUES('Drashtant','Kumar',29),('Aaradhana','Kumari',26),('Rani','Devi',58),('Lakshman','Prasad',59)");
//		  if(val==1) 
//			  System.out.print("Successfully inserted value");
		
			//  }
		  /*while (res.next()) 
		  { int id = res.getInt("id"); 
		  String msg = res.getString("msg");
		  System.out.println(id + "\t" + msg); 
		  } 
		  int val = st.executeUpdate("INSERT into event VALUES("+1+","+"'Easy'"+")");
		  if(val==1) 
			  System.out.print("Successfully inserted value");
*/
		 // Read more: http://mrbool.com/how-to-connect-with-mysql-database-using-java/25440#ixzz4Yly0c300
		 // conn.close();
		  } catch (Exception e) {
		  e.printStackTrace();
		  }
		  finally{
			  conn.close();
		  }

	
}
public String getData() {
	String str = "";
for(Persons u:users)
{
	//System.out.print(u.getFirstName() +" "+u.getLastName() +" "+u.getAge());
	//System.out.println();
	str +=u.getFirstName() +" "+u.getLastName() +" "+u.getAge()+"\n";
	return str;
}
return str;
}
}
