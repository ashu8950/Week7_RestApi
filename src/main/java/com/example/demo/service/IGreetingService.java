package com.example.demo.service;


import com.example.demo.dto.GreetingDto;
import com.example.demo.model.User;

public interface IGreetingService {
	GreetingDto addGreet(User user);
}
