package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GreetingDto;
import com.example.demo.model.User;
import com.example.demo.service.GreetingService;

@RestController
@RequestMapping("/greetData")
public class GreetingControllerDatabase {
	
	@Autowired
	private GreetingService greetingService;
	
	@GetMapping("/greet")
	public GreetingDto greeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
	                         @RequestParam(value = "lastName", defaultValue = "") String lastName) {
	    User user = new User();
	    user.setFirstName(firstName);
	    user.setLastName(lastName);

	    return greetingService.addGreet(user);
	}

}
