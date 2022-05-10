package com.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserDTO {
	private String fullName;
	private String userName;
	private String address;
	private String MaritalStatus;
	private String password;
	private String qualification;
	private List<String> highEdu = new ArrayList<String>();
	
	

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMaritalStatus() {
		return MaritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public  String getHighEdu() {
		return highEdu.toString();
	}
	public void setHighEdu(String dip,String deg, String mas) {
		if(dip !=null) {
			this.highEdu.add(dip);
		}
		if(deg !=null) {
			this.highEdu.add(deg);
		}
		if(mas !=null) {
			this.highEdu.add(mas);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
