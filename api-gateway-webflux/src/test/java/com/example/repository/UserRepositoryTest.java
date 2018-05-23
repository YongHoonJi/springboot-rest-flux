package com.example.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ApiGatewayWebfluxApplication;
import com.example.dto.tables.records.UserRecord;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiGatewayWebfluxApplication.class)
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;
	@Test
	public void getUser() {
		try {
			UserRecord r = this.repository.getUser(1);
			System.out.println(r.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
