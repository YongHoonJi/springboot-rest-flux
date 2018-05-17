package com.example.controller;



import java.util.Arrays;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.info.TranslationRequest;
import com.example.info.TranslationResponse;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

@RequestMapping("translate")
@RestController
public class TranslationController {
	@ApiOperation(value = "", notes = "Request a task(systran)", response = TranslationResponse.class)
	@PostMapping("/translate/{taskId}")
	public Mono<ResponseEntity<TranslationResponse>> request(
			@PathVariable long taskId,
			@RequestBody TranslationRequest req
			) {
		return this.buildMonoMock(taskId, req)
				.map( s -> ResponseEntity.ok(s))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	private Mono<TranslationResponse> buildMonoMock(long requestId, TranslationRequest req) {
		return Mono.just(new TranslationResponse(requestId, Arrays.asList("텍스트1", "텍스트2"), Arrays.asList("text1", "text2"), "koen", "RBMT",
				new Date(), new Date()));
	}
	
}
