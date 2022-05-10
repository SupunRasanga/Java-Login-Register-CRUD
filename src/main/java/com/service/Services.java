package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.UserDTO;
import com.util.JDBCUtil;

public class Services {
	
	//User Registration
	public static void registerUser(UserDTO ud) throws SQLException{
		Connection connection = null;
		PreparedStatement prest = null;
		
		String innerSql = "INSERT INTO users (user_name,full_name,address,marital_status,password,qualification,high_education)VALUES(?,?,?,?,?,?,?)";
		
		try {
			connection = JDBCUtil.getConnection();
			prest = connection.prepareStatement(innerSql);
			prest.setString(1, ud.getUserName());
			prest.setString(2, ud.getFullName());
			prest.setString(3, ud.getAddress());
			prest.setString(4, ud.getMaritalStatus());
			prest.setString(6, ud.getQualification());
			prest.setString(7, ud.getHighEdu());
			prest.setString(5, ud.getPassword());
			
			System.out.println(ud.getHighEdu());
			
			int returnValue = prest.executeUpdate();
			System.out.println("Retuen of Insert SQL - "+returnValue);
			
		}catch(SQLException e) {
			System.out.println("Insert Faild "+e.getMessage());
		}finally {
			prest.close();
			connection.close();
		}
		
	}
	//User Login
	public static UserDTO getUserAuthentication(String userName) throws SQLException {
		Connection connection = null;
		PreparedStatement prest = null;
		
		String getUserSQL = "SELECT user_name,password FROM users WHERE user_name = ?";
		UserDTO user = new UserDTO();
		try {
			connection = JDBCUtil.getConnection();
			prest = connection.prepareStatement(getUserSQL);
			prest.setString(1, userName);
			ResultSet rs = prest.executeQuery();
			
			while(rs.next()) {
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			prest.close();
			connection.close();
		} return user;
	}
	
	
	
}
