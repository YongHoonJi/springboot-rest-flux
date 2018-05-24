package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.info.User;
import com.example.repository.UserRepository;

@Service
public class UserSerivce {
	
	private UserRepository repository;
	
	@Autowired
	public UserSerivce(UserRepository repository) {
		this.repository = repository;
	}
	
	public Optional<User> getUser(int id) {
		return Optional.of(this.repository.getUser(id).into(User.class));
	}

}
