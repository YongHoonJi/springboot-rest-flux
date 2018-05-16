package com.example.controller;


import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.info.JobRequest;

import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@RestController("job")
public class JobRequestController {
	@ApiOperation(value = "", notes = "Request a job", response = JobRequest.class)
	@GetMapping("/request")
	public Mono<ResponseEntity<JobRequest>> getUser() {
		return this.getFromRepository().map( s -> ResponseEntity.ok(s)).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	private Mono<JobRequest> getFromRepository() {
		// expect getting from repository
		return Mono.just(new JobRequest(1L, 2L, "test@a.com", "name", "file.pdf", "pdf", "binary", new Date(), 400L, "word", "enko", new Date(),
				"patent", "TR"));
	}
	

}
