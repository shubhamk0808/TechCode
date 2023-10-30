package com.shubham.springmvc.techcode.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomErrorController implements ErrorController {
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		
		String customErrorPage = "error";
		Object errorCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(errorCode != null) {
			int statusCode = Integer.valueOf(errorCode.toString());
			
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				customErrorPage = "error/error-404";
				log.error("404 Error encountered. ");
			}else if(statusCode == HttpStatus.FORBIDDEN.value()) {
				customErrorPage = "error/error-403";
				log.error("403 Error encountered. ");
			}else{
				customErrorPage = "error/error-500";
				log.error("500 Error. Something went wrong.");
			}
		}
		
		return customErrorPage;
	}

}
