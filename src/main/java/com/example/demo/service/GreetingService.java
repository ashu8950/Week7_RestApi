package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

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
	 
	//fetching by id
	
	public GreetingDto getGreetingById(Long id) {
		// TODO Auto-generated method stub
		GreetingDto greeting = greetingRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Greeting not found with ID: " + id));
		return new GreetingDto(greeting.getId(),greeting.getMessage());
	}
	//listing all data
	 public List<GreetingDto> getAllGreetings() {
	        return greetingRepository.findAll().stream()
	                .map(greeting -> new GreetingDto(greeting.getId(), greeting.getMessage()))
	                .collect(Collectors.toList());
	    }
	 
	 //updating greeting
	 public GreetingDto updateGreeting(Long id, String newMessage) {
		    Optional<GreetingDto> optionalGreeting = greetingRepository.findById(id);

		    if (optionalGreeting.isPresent()) {
		        GreetingDto greeting = optionalGreeting.get();
		        greeting.setMessage(newMessage);
		        GreetingDto updatedGreeting = greetingRepository.save(greeting);
		        return new GreetingDto(updatedGreeting.getId(), updatedGreeting.getMessage());
		    } else {
		        throw new RuntimeException("Greeting with ID " + id + " not found.");
		    }
		}
	 
	 //delete data
	 public String deleteGreeting(Long id) {
		    if (greetingRepository.existsById(id)) {
		        greetingRepository.deleteById(id);
		        return "Greeting with ID " + id + " has been deleted.";
		    } else {
		        throw new RuntimeException("Greeting with ID " + id + " not found.");
		    }
		}

}
