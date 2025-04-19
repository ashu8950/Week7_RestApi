package com.example.demo.service;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.stereotype.Service;

import com.example.demo.dto.GreetingDto;
import com.example.demo.model.User;
import com.example.demo.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {
	private static final String template = "Hello %s";
	private static final AtomicLong counter = new AtomicLong();
	
	
	private GreetingRepository greetingRepository;
	
	 
	 public GreetingService(GreetingRepository greetingRepository) {
	     this.greetingRepository = greetingRepository;
	 }
	 
		/*UC4->Ability for the Greeting
		
		App to save the
		
		Greeting Message in the
		
		Repository*/
	@Override
    public GreetingDto addGreet(User user) {
        String message = user.toString().isBlank() ? "Hello World" : String.format(template, user.toString());
        return greetingRepository.save(new GreetingDto(counter.incrementAndGet(), message));
    }
	 
	
	public GreetingDto getGreetingById(Long id) {
		// TODO Auto-generated method stub
		GreetingDto greeting = greetingRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Greeting not found with ID: " + id));
		return new GreetingDto(greeting.getId(),greeting.getMessage());
	}
}
