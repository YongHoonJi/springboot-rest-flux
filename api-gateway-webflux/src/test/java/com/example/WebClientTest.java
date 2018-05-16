package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.info.User;

@RunWith(SpringRunner.class)
@WebFluxTest
@Import(value=ApiGatewayWebfluxApplication.class)
public class WebClientTest {
	
	@Autowired
	private WebTestClient webClient;
	
	@Test
	public void testClient() {
		User user = webClient.get().uri("/user").exchange().expectStatus().isOk().expectBody(User.class).returnResult().getResponseBody();
		System.out.println(user.toString());
				
	}
}
