package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*UC1 -> Create Spring App for
Hello Messages using
different HTTP Methods.

Test using curl*/

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	
	@GetMapping
	public String getHello(){
		return "hello from get";
	}
	
	@PostMapping
	public String postHello()
	{
		return "Hello from Post";
	}
	
	@PutMapping
	public String putHello() {
		return "Hello from put";
	}
	
	@DeleteMapping
	public String deleteHello() {
		return "Hello from delete";
	}
	
}
