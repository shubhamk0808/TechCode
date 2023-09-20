package com.shubham.springmvc.techcode.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.springmvc.techcode.model.Holiday;

@Controller
public class HolidayController {

	// url formed = http://localhost:8080/holidays?festival=true&govt=true
	
	@GetMapping("/holidays")
	public ModelAndView displayHolidayPage(@RequestParam(required = false) boolean festival,
			@RequestParam(required = false) boolean govt) {
		

		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("festival", festival);
		modelAndView.addObject("govt", govt);
		
		List<Holiday> holidays = Arrays.asList(
			new Holiday("06-Sep", "Janmashtami (Smarta)", Holiday.Type.FESTIVAL),
			new Holiday("07-Sep", "Janmashtami", Holiday.Type.GOVERNMENT),
			new Holiday("19-Sep", "Ganesh Chaturthi/Vinayaka Chaturthi", Holiday.Type.FESTIVAL),
			new Holiday("23-Sep", "September Equinox", Holiday.Type.FESTIVAL),
			new Holiday("28-Sep", "Milad un-Nabi/Id-e-Milad (Tentative Date)", Holiday.Type.GOVERNMENT),
			new Holiday("02-Oct", "Mahatma Gandhi Jayanti", Holiday.Type.GOVERNMENT),
			new Holiday("15-Oct", "First Day of Sharad Navratri", Holiday.Type.FESTIVAL),
			new Holiday("20-Oct", "First Day of Durga Puja Festivities", Holiday.Type.FESTIVAL),
			new Holiday("21-Oct", "Maha Saptami", Holiday.Type.FESTIVAL),
			new Holiday("22-Oct", "Maha Ashtami", Holiday.Type.FESTIVAL),
			new Holiday("23-Oct", "Maha Navami", Holiday.Type.FESTIVAL),
			new Holiday("24-Oct", "Dussehra", Holiday.Type.GOVERNMENT),
			new Holiday("28-Oct", "Maharishi Valmiki Jayanti", Holiday.Type.FESTIVAL),
			new Holiday("31-Oct", "Halloween", Holiday.Type.FESTIVAL),
			new Holiday("01-Nov", "Karaka Chaturthi (Karva Chauth)", Holiday.Type.FESTIVAL),
			new Holiday("12-Nov", "Naraka Chaturdasi", Holiday.Type.FESTIVAL),
			new Holiday("12-Nov", "Diwali/Deepavali", Holiday.Type.GOVERNMENT),
			new Holiday("13-Nov", "Govardhan Puja", Holiday.Type.FESTIVAL),
			new Holiday("15-Nov", "Bhai Duj", Holiday.Type.FESTIVAL),
			new Holiday("19-Nov", "Chhat Puja (Pratihar Sashthi/Surya Sashthi)", Holiday.Type.FESTIVAL),
			new Holiday("24-Nov", "Guru Tegh Bahadur's Martyrdom Day", Holiday.Type.FESTIVAL),
			new Holiday("27-Nov", "Guru Nanak Jayanti", Holiday.Type.GOVERNMENT),
			new Holiday("08-Dec", "First Day of Hanukkah", Holiday.Type.FESTIVAL),
			new Holiday("15-Dec", "Last day of Hanukkah", Holiday.Type.FESTIVAL),
			new Holiday("22-Dec", "December Solstice", Holiday.Type.FESTIVAL),
			new Holiday("24-Dec", "Christmas Eve", Holiday.Type.FESTIVAL),
			new Holiday("25-Dec", "Christmas", Holiday.Type.GOVERNMENT),
			new Holiday("31-Dec", "New Year's Eve", Holiday.Type.FESTIVAL)
		);
		
		Holiday.Type[] holiTypes = Holiday.Type.values();
		
		for(Holiday.Type type : holiTypes) {
			modelAndView.addObject(type.toString(), 
					holidays.stream()
					.filter(holiday -> holiday.getType().equals(type))
					.collect(Collectors.toList()));
		}
		
		modelAndView.setViewName("holidays.html");
		return modelAndView;
	}
}
