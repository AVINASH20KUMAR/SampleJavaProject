<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
     <%@ page import="com.servlets.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  
<table>

<tr>fname="<%= request.getAttribute("FNAME") %>"</tr> 
<tr>lname="<%= request.getAttribute("LNAME") %>"</tr> 
<tr>age="<%= request.getAttribute("AGE") %>"</tr>

 </table>
 -->
  
 
 <%
		ArrayList<Persons> users = (ArrayList) request.getAttribute("users");
		//out.println("Servlet communicated message to JSP: "+ message);
		out.print("FirstName" +"<tr> "+" LastName"+"<tr> " +"Age");	
		out.println("<br>");
		
		for(Persons u:users)
		{
			String fn = u.getFirstName();
			String ln = u.getLastName(); 
			int age = u.getAge();
			//System.out.println("firstname = " + fn);
//		String fn = request.getParameter("firstname");
//		String ln =request.getParameter("lastname");
//		int age = Integer.valueOf(request.getParameter("age"));
			

	
			out.print(u.getFirstName() +"<tr> "+u.getLastName() +"<tr>"+u.getAge());
			out.println("<br>");
		
		//	request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	
%>


</body>
</html>