package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.dto.UserDTO;
import com.service.Services;
import com.util.JDBCUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get user inputs for variable 
		String userI = request.getParameter("user");
		String userP = request.getParameter("pass");
		try {
				UserDTO ud = Services.getUserAuthentication(userI);
				String userName = ud.getUserName();
				String password = ud.getPassword();
				
				//check authentication
				if(userName != null && userName.equals(userI) && password.equals(userP)) {
					JOptionPane optionPane = new JOptionPane("You are login successfully",JOptionPane.NO_OPTION);
					JDialog dialog = optionPane.createDialog("Thank You !");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
					RequestDispatcher dispatcher3 = request.getRequestDispatcher("home.jsp");
					dispatcher3.forward( request, response);
				}else {
					JOptionPane optionPane = new JOptionPane("Your username and password doesn't match",JOptionPane.NO_OPTION);
					JDialog dialog = optionPane.createDialog("Worning !");
					dialog.setAlwaysOnTop(true); // to show top of all other application
					dialog.setVisible(true); // to visible the dialog
					RequestDispatcher dispatcher3 = request.getRequestDispatcher("index.html");
					dispatcher3.forward( request, response);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
	}
}

