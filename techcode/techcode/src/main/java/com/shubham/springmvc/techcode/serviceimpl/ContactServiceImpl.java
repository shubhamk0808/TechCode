package com.shubham.springmvc.techcode.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shubham.springmvc.techcode.model.Contact;
import com.shubham.springmvc.techcode.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	private static Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class); 
	
	@Override
	public boolean saveQueryDetails(Contact contact) {
		boolean isSaved = false;
		logger.info(contact.toString());
		isSaved = true;
		return isSaved;
	}

}
