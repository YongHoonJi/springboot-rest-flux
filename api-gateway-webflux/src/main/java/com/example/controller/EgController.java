package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.info.User;
import reactor.core.publisher.Mono;

@RestController
public class EgController {
	
	@GetMapping("/user")
	public Mono<ResponseEntity<User>> getUser() {
		return this.getFromRepository().map( s -> ResponseEntity.ok(s)).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	private Mono<User> getFromRepository() {
		// expect getting from repository
		return Mono.just(new User("sam", "test@a.com"));
	}
	

}
