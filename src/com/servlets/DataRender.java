package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.JavaAndMySQL;

/**
 * Servlet implementation class DataRenderingModule
 */
@WebServlet(description = "MyLoginDatabase", urlPatterns = { "/DataRender" })
public class DataRender extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static List<Persons> users = new ArrayList<Persons>();
	JavaAndMySQL jmysql;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataRender() {
        super();
       //doPost();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		try {
			users = jmysql.main1();
			System.out.println("Hello \n"+users);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Persons u:users)
		{
			String fn = u.getFirstName();
			String ln = u.getLastName(); 
			int age = u.getAge();
			/*
			 * 
			System.out.println("firstname = " + fn);
			String fn = request.getParameter("firstname");
			String ln =request.getParameter("lastname");
			int age = Integer.valueOf(request.getParameter("age"));
			out.print(fn +" "+" "+ ln +" "+age);
			out.print(u.getFirstName() +" "+u.getLastName() +" "+u.getAge());
			out.println();
			request.setAttribute("FNAME", fn); 
			request.setAttribute("LNAME",ln); 
			request.setAttribute("AGE", age);
			
			*/
			
		}
		
		//request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		//out.print("Hello"+ ndb.getData());
		//doPost(request, response);
		//request.setAttribute("userList",JavaAndMySQL.users);
	   // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
	   // dispatcher.forward(request,response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Persons> users = new ArrayList<Persons>();
		try {
			users = jmysql.main1();
			System.out.println(users);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		for(Persons u:users)
		{
			String fn = u.getFirstName();
			String ln = u.getLastName(); 
			int age = u.getAge();
			System.out.println("firstname = " + fn);
//		String fn = request.getParameter("firstname");
//		String ln =request.getParameter("lastname");
//		int age = Integer.valueOf(request.getParameter("age"));
//		out.print(fn +" "+" "+ ln +" "+age);
			//out.print(u.getFirstName() +" "+u.getLastName() +" "+u.getAge());
			//out.println();
			request.setAttribute("FNAME", fn); 
			request.setAttribute("LNAME",ln); 
			request.setAttribute("AGE", age);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		*/
		request.setAttribute("users", users);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	//	request.setAttribute("userList",JavaAndMySQL.users);
	    //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
	   // dispatcher.forward(request,response);
	  //  request.getRequestDispatcher("/login.jsp").forward(request, response);
		//response.setContentType("text/html");
        
        }

}
