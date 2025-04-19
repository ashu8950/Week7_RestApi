package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/*UC3 ->Ability for the Greeting App to
		give Greeting message with
		
		1. User First Name and Last
		Name or
		2. With just First Name or Last
		Name based on User
		attributes provides or
		3. Just Hello World.*/
	
	@GetMapping("/greet")
	public GreetingDto greeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
	                         @RequestParam(value = "lastName", defaultValue = "") String lastName) {
	    User user = new User();
	    user.setFirstName(firstName);
	    user.setLastName(lastName);

	    return greetingService.addGreet(user);
	}
	
	/*UC5->Ability for the Greeting

		App to find a Greeting
		
		Message by Id in the
		
		Repository*/
	
	@GetMapping("/find")
	public GreetingDto getGreetingById(@RequestParam Long id) {
		return greetingService.getGreetingById(id);
	}
	
	/*UC6->Ability for the Greeting

	App to List all the
	
	Greeting Messages in
	
	the Repository*/
	
	@GetMapping("/all")
	public List<GreetingDto> getAllGreetings() {
	    return greetingService.getAllGreetings();
	}
	
	/*UC7->Ability for the Greeting

	App to Edit a Greeting
	
	Messages in the
	
	Repository*/
	
	@PutMapping("/update")
	public GreetingDto updateGreeting(@RequestBody GreetingDto request) {
	    return greetingService.updateGreeting(request.getId(), request.getMessage());
	}
	/*UC8-> Ability for the Greeting

	App to delete a Greeting
	
	Messages in the
	
	Repository*/
	@DeleteMapping("/delete/{id}")
	public String deleteGreeting(@PathVariable Long id) {
	    return greetingService.deleteGreeting(id);
	}
}
