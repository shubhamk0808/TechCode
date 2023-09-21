package com.shubham.springmvc.techcode.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Contact {

	@NotBlank(message = "Name must not be blank.")
	@Size(min = 3, message = "Name must be at least 3 characters long")
	private String userName;
	
	@NotBlank(message="Email must not be blank")
	@Email(message = "Please provide a valid email address" )
	private String userMail;
	
	@NotBlank(message="Subject must not be blank")
    @Size(min=5, message="Subject must be at least 5 characters long")
	String userSubject;
	
	@NotBlank(message="Message must not be blank")
    @Size(min=10, message="Message must be at least 10 characters long")
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
