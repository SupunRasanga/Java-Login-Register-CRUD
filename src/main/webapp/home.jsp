<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
<style>
#stud {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#stud td, #stud th {
  border: 1px solid #ddd;
  padding: 8px;
}

#stud tr:nth-child(even){background-color: #f2f2f2;}

#stud tr:hover {background-color: #ddd;}

#stud th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: black;
  color: white;
}
</style>
</head>
<body>
	<div align="center">
	<h1>User Details</h1>
	<table id="stud">
		<tr>
		<th>User Name</th>
		<th>Full Name</th>
		<th>Address</th>
		<th>Marital Status</th>
		<th>Password</th>
		<th>Qualification</th>
		<th>Higher Education</th>
		</tr>
		
		
		
		<%
		
		try{
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyWebApp","postgres","root");
			String selectSQL = "SELECT * FROM users";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(selectSQL);
			while(rs.next()){
				%>
					<tr>
					<td><%=rs.getString("user_name") %></td>
					<td><%=rs.getString("full_name") %></td>
					<td><%=rs.getString("address") %></td>
					<td><%=rs.getString("marital_status") %></td>
					<td><%=rs.getString("password") %></td>
					<td><%=rs.getString("qualification") %></td>
					<td><%=rs.getString("high_education") %></td>
					</tr>
				<%
			}
		}catch(Exception ex){
			out.println(ex.getMessage());
			ex.printStackTrace();
		}
		%>

		
	</table>
	
	</div>
</body>
</html>