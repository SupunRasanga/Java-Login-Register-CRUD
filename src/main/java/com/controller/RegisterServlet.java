package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.dto.UserDTO;
import com.service.Services;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Get !");
//		
//		//Request Value
//		String fullName = request.getParameter("fName");
//		
//		
//		
//		//Session Value
//		HttpSession session = request.getSession();
//		
//		//Application Context Value
//		ServletContext context = request.getServletContext();
//		
//		if(fullName != null) {
//			session.setAttribute("sessionFullName", fullName);
//			context.setAttribute("contextFullName",fullName);
//		}
//		
//		//Application Context
//		System.out.println("Request Full Name = "+fullName);
//		System.out.println("Session Full Name = "+session.getAttribute("sessionFullName"));
//		System.out.println("Context Full Name = "+context.getAttribute("contextFullName"));
//		
//		PrintWriter writer = response.getWriter();
//		writer.print("Request Full Name = "+fullName);
//		writer.print(" Session Full Name = "+session.getAttribute("sessionFullName"));
//		writer.print(" Context Full Name = "+context.getAttribute("contextFullName"));
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDTO us = new UserDTO();
		us.setFullName(request.getParameter("fName"));
		us.setUserName(request.getParameter("uName"));
		us.setAddress(request.getParameter("address"));
		us.setMaritalStatus(request.getParameter("status"));
		us.setQualification(request.getParameter("quli"));
		us.setHighEdu(request.getParameter("dip"), request.getParameter("deg"), request.getParameter("mas"));
		
		//Check Passwords
		String pass  =request.getParameter("pass");
		String cpass =request.getParameter("cPass");
		if(pass .equals(cpass)) {
			us.setPassword(pass);
			try {
				String userI = request.getParameter("user");
				UserDTO ud = Services.getUserAuthentication(userI);
				String userName = ud.getUserName();
				
				if(userI != userName || userName==null) {
					try {
						Services.registerUser(us);
						JOptionPane optionPane = new JOptionPane("Registration successfully",JOptionPane.NO_OPTION);
						JDialog dialog = optionPane.createDialog("Thank You !");
						dialog.setAlwaysOnTop(true); // to show top of all other application
						dialog.setVisible(true); // to visible the dialog
						RequestDispatcher dispatcher3 = request.getRequestDispatcher("register.html");
						dispatcher3.forward( request, response);
					
						} catch (SQLException e) {
							
						}
				}else {
					JOptionPane optionPane = new JOptionPane("Your details invalid or already exits",JOptionPane.NO_OPTION);
					JDialog dialog = optionPane.createDialog("Thank You !");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true);
					RequestDispatcher dispatcher3 = request.getRequestDispatcher("register.html");
					dispatcher3.forward( request, response);
				}
			}catch(SQLException e) {
				
			}
		
	
		}else { 
			JOptionPane optionPane = new JOptionPane("Your passwords doesn't match",JOptionPane.NO_OPTION);
			JDialog dialog = optionPane.createDialog("Worning !");
			dialog.setAlwaysOnTop(true); // to show top of all other application
			dialog.setVisible(true); // to visible the dialog
			RequestDispatcher dispatcher3 = request.getRequestDispatcher("register.html");
			dispatcher3.forward( request, response);
			
		}
		
		
		
		
//		String fullName = request.getParameter("fName");
//		String userName = request.getParameter("uName");
//		String address = request.getParameter("address");
//		String maritialStatus = request.getParameter("status");
//		String qualification = request.getParameter("quli");
//		
//		//String[] highEdu = request.getParameter("dip");
//		
//		System.out.println("Name = "+fullName);
//		System.out.println("User Name = "+userName);
//		System.out.println("Address = "+address);
//		System.out.println("Status = "+maritialStatus);
//		System.out.println("Name = "+fullName);
//	  //System.out.println("Q1 ="+highEdu[0]+"Q2");
//		
//		PrintWriter writer = response.getWriter();
//		
//		writer.print("<b>This is the heading</b> </br>");
//		
//		writer.print(" Name = "+fullName+"<br>");
//		writer.print("User Name = "+userName+"<br>");
//		writer.print(" Address = "+address+"<br>");
//		writer.print(" Status = "+maritialStatus+"<br>");
	}

}
