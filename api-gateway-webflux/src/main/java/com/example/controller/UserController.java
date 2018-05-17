package com.example.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.info.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import reactor.core.publisher.Mono;

@RequestMapping("user")
@RestController
public class UserController {
	@ApiOperation(value = "", notes = "get a user info(wert)", response = User.class)
	@GetMapping("/{userId}")
	public Mono<ResponseEntity<User>> request(
			@ApiParam(value = "사용자 id", required = true)
			@PathVariable long userId
			) {
		return this.buidlMockuser(userId)
				.map( s -> ResponseEntity.ok(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	private Mono<User> buidlMockuser(long userId) {
		// expect getting from repository
		return Mono.just(new User(userId, "sam", "test@a.com"));
	}
	
}
