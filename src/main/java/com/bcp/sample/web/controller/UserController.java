package com.bcp.sample.web.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bcp.sample.domain.Role;
import com.bcp.sample.domain.User;
import com.bcp.sample.model.service.PersonService;


@Controller
@RequestMapping("/person")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private PersonService personService;
	
	@Autowired
	public UserController( @Qualifier("personService01") PersonService personService){
		logger.info("PersonController no-arg constructor");
		this.personService = personService;
	}
	
	@RequestMapping
	public String home(Model model){
		model.addAttribute("message", "Welcome!!!");
		return "message";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerPerson(Model model){
		User person = new User();
		person.setRole(Role.ADMIN);
		model.addAttribute("person", person);
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPerson(User person, Model model){
		
		person.setRole(Role.ADMIN);
		this.personService.insertPerson(person);
		model.addAttribute("message", "Record saved successfully");
		return "message";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String searchPerson(){
		return "search";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchPersonById(@RequestParam("id") String id, Model model){
		try{
			model.addAttribute("person", this.personService.getPersonById(Long.parseLong(id)));
			return "detail";
		}
		catch(Exception e){
			model.addAttribute("message", "Error: Record not found");
			return "message";	
		}
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detailPersonById(@RequestParam("id") String id, Model model){
		try{
			model.addAttribute("person", this.personService.getPersonById(Long.parseLong(id)));
			return "detail";
		}
		catch(Exception e){
			model.addAttribute("message", "Error: Record not found");
			return "message";	
		}
	}
	
	@RequestMapping("/report")
	public String reportPerson(Model model){
		Set<User> persons = new LinkedHashSet<User>();
		persons = this.personService.getAllPerson();
		
		if(persons.isEmpty()){
			model.addAttribute("message", "Error: No Records Available");
			return "message";
		}
		else{
			 model.addAttribute("persons", persons);
			return "report";	
		}
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editPersonById(@RequestParam("id") String id, Model model){
		try{
			model.addAttribute("person", this.personService.getPersonById(Long.parseLong(id)));
			return "edit";
		}
		catch(Exception e){
			model.addAttribute("message", "Error: Record not found");
			return "message";	
		}
	}
		
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editPerson(User person, Model model){
		person.setRole(Role.ADMIN);
		this.personService.updatePerson(person);
		model.addAttribute("message", "Record updated successfully");
		return "message";
	}
	
	@RequestMapping(value="/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String deletePersonById(@RequestParam("id") String id, Model model){
		this.personService.deletePersonById(id);
		model.addAttribute("message", "Record deleted successfully");
		return "message";
	}
	
}
