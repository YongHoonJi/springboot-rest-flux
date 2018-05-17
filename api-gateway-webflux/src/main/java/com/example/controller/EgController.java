package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.info.User;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@RequestMapping("job")
@RestController
public class EgController {
	@ApiOperation(value = "", notes = "Gets user (json)", response = User.class)
	@GetMapping("/user")
	public Mono<ResponseEntity<User>> getUser() {
		return this.getFromRepository().map( s -> ResponseEntity.ok(s)).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	private Mono<User> getFromRepository() {
		// expect getting from repository
		return Mono.just(new User(1L, "sam", "test@a.com"));
	}

}
