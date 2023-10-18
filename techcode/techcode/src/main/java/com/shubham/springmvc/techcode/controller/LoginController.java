package com.shubham.springmvc.techcode.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String displayLoginPage(@RequestParam(value="error", required = false) String error,
									@RequestParam(value="logout", required = false) String logout, 
									Model model, Authentication authentication, HttpServletRequest request) {
		
		log.info("Method = " + request.getMethod().toString());
//		log.info(authentication.getName(), authentication.getAuthorities().toString());
		String errorMsg = null;
		if(error != null) {
			errorMsg = "Invalid credentials !!";
			log.error("Invalid credentials detected. Login Denied.");
		}
		
		if(logout != null) {
			errorMsg = "You have been successfully logged out!!";
		}
		model.addAttribute("errorMessage", errorMsg);
		return "login.html";
	}
}
