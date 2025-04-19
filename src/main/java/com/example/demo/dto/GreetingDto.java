package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GreetingDto {
    
    @Id
    private Long id;
    
    private String message;

    public GreetingDto() {
    }

    public GreetingDto(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
