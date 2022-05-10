<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import = "java.util.Date" %>    
<%@ page  import = "java.util.List" %>    
<%@ page  import = "java.util.ArrayList" %>    



  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2>This is heading</h2>
	
	int a = 10;
	int b = 15;
	int c = a+b;
	System.out.println(c);
	
	<br>
	
	<%
	int a = 10;
	int b = 15;
	int c = a+b;
	out.println(c);
	%>
	
	<br>
	
	The value of C = <%=c %>
	
	<%!
	
	public int addNumbers(int a, int b){
		return a+b;
	}
	
	%>
	
	<br>
	
	Addition of 5,4 = <%=addNumbers(5, 4) %>
	
	<br>
	
	<%
	
	for(int i =0; i<5;i++){
		out.println("I = "+i+"<br>");
	}
	
	%>
	
	<br>
	
	<%
		for(int i =1; i<10; i++){
	%>
	
	<br/> I =<%=i %>
	
	<%
	}
	%>
	
	<br>
	
	Date date = new Date();
	<br>
	Date and Time = <%= new Date() %>
	
	Collection of Names<br>
	
	<%
	List<String> names = new ArrayList<String>();
	names.add("Nimal");
	names.add("Kamal");
	names.add("Chamila");
	%>
	
	<%
	for(String name: names){
		out.println(name);
	}
	%>
	
	<br/>
	Request, Session, Application/Context
	
	<%
	String name = request.getParameter("fName");
	if(name!= null){
		session.setAttribute("sessionName", name);
		application.setAttribute("applicationName",name);
		
	}
	
	%>
	
	<br/>
	
	Name of the Request Scope = <%=name %> <br/>
	Name of the Session Scope = <%=session.getAttribute("sessionName") %> <br/>
	Name of the Application Scope = <%=application.getAttribute("applicationName") %> <br/>
	
	<%@ include file="footer.jsp"%>
	
</body>
</html>