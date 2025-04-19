package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.GreetingDto;


public interface GreetingRepository extends JpaRepository<GreetingDto,Long> {

}
