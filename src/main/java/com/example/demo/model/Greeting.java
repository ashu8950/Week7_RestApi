package com.example.demo.model;

public class Greeting {
	
	private Long id;
	private String message;
	
	public Greeting(Long id , String message){
		this.setId(id);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
