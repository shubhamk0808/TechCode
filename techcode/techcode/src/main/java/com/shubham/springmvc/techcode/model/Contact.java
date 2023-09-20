package com.shubham.springmvc.techcode.model;

public class Contact {

	String userName;
	String userMail;
	String userSubject;
	String userMessage;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserSubject() {
		return userSubject;
	}
	public void setUserSubject(String userSubject) {
		this.userSubject = userSubject;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	
	@Override
	public String toString() {
		return "Contact [userName=" + userName + ", userMail=" + userMail + ", userSubject=" + userSubject
				+ ", userMessage=" + userMessage + "]";
	}
	
}
