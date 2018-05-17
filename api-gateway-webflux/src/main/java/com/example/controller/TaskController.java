package com.example.controller;


import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.info.TaskRequest;
import com.example.info.TaskResponse;
import com.example.info.TaskStatus;
import com.example.info.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("task")
@RestController
public class TaskController {
	@ApiOperation(value = "", notes = "Request a task(systran)", response = TaskRequest.class)
	@PostMapping("/request/{taskId}")
	public Mono<ResponseEntity<TaskRequest>> request(
			@PathVariable long taskId,
			@RequestBody User user
			) {
		return this.buildMockRequest(taskId, user)
				.map( s -> ResponseEntity.ok(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@ApiOperation(value = "", notes = "check a task(systran)", response = TaskStatus.class)
	@GetMapping("/check/{userId}/{taskId}")
	public Mono<ResponseEntity<TaskStatus>> check(
			@ApiParam(value = "사용자 id", required = true)
			@PathVariable long userId,
			@ApiParam(value = "태스크 id", required = true)
			@PathVariable long id
			) {
		return this.buildMockStatus(userId, id)
				.map( s -> ResponseEntity.ok(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}	
	
	@ApiOperation(value = "", notes = "check user's tasks(systran)", response = TaskStatus.class)
	@GetMapping("/check/{userId}")
	public Flux<ResponseEntity<TaskStatus>> check(
			@ApiParam(value = "사용자 id", required = true)
			@PathVariable long userId
			) {
		return this.buildMocksStatus(userId)
				.map( s -> ResponseEntity.ok(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}	
	
	@ApiOperation(value = "", notes = "response a task(wert)", response = TaskResponse.class)
	@PostMapping("/response/{taskId}")
	public Mono<ResponseEntity<TaskResponse>> response(
			@ApiParam(value = "태스크 id", required = true)
			@PathVariable long taskId
			) {
		return this.buildMockResponse(taskId)
				.map( s -> ResponseEntity.ok(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}	
	
	private Mono<TaskRequest> buildMockRequest(long taskId, User user) {
		return Mono.just(new TaskRequest(taskId, user, "file.pdf", "pdf", "N", "binary", new Date(), 400L, "word", "enko", new Date(),
				"patent", "TR"));
	}
	
	private Mono<TaskStatus> buildMockStatus(long userId, long id) {
		return Mono.just(new TaskStatus(userId, id, "작업 중", "ONG"));
	}
	
	private Flux<TaskStatus> buildMocksStatus(long userId) {
		return Flux.just(
				new TaskStatus(userId, 1L, "작업 중", "ONG"),
				new TaskStatus(userId, 1L, "작업 완료", "COP")
				);
	}	
	
	private Mono<TaskResponse> buildMockResponse(long id) {
		return Mono.just(new TaskResponse(1L, id, "file.pdf", "pdf", "No comment", "data"));
	}	
	
}
