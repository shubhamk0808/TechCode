package com.shubham.springmvc.techcode.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.springmvc.techcode.model.Contact;
import com.shubham.springmvc.techcode.service.ContactService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ContactController {
	
	//private static Logger logger = LoggerFactory.getLogger(ContactController.class);

	private final ContactService contactService;
	
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping("/contact")
	public String displayContactPage(Model model) {

		return "contact.html";
	}

	/*
	
	 * This way of accepting data from View requires declaring a lot of parameters,
	 * which makes the code look complex and clumsy. So, we will use another way by
	 * declaring a POJO class, and mapping the variable there.
	 
	
	@PostMapping("/saveUserQuery")
	public ModelAndView saveQuery(@RequestParam String userName, @RequestParam String userMail,
			@RequestParam String userSubject, @RequestParam String userMessage) {
		ModelAndView modelAndView = new ModelAndView();

		logger.info(userName + userMail + userSubject + userMessage);
		modelAndView.setViewName("redirect:/contact");
		return modelAndView;
	}
	
	*/
	
	@PostMapping("/saveUserQuery")
	public ModelAndView saveQuery(Contact contact) {
		ModelAndView modelAndView = new ModelAndView();
		boolean isSaved = contactService.saveQueryDetails(contact);
		log.info("Data saved successfuly ? : " + (isSaved ? "Yes" : "No"));
		modelAndView.setViewName("redirect:/contact");
		return modelAndView;
	}
}
