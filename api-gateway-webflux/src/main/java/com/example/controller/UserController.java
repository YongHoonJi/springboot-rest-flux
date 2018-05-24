package com.example.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.tables.records.UserRecord;
import com.example.info.User;
import com.example.service.UserSerivce;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import reactor.core.publisher.Mono;

@RequestMapping("user")
@RestController
public class UserController {
	@Autowired
	private UserSerivce service;
	
	@ApiOperation(value = "", notes = "get a user info(wert)", response = User.class)
	@GetMapping("/{userId}")
	public Mono<ResponseEntity<User>> request(
			@ApiParam(value = "사용자 id", required = true)
			@PathVariable int userId
			) {
		return this.buidlMockuser(userId)
				.map( s -> ResponseEntity.ok(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	private Mono<User> buidlMockuser(int userId) {
		// expect getting from repository
		return Mono.just(this.service.getUser(userId).get());
	}
	
}
