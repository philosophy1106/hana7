package com.hana7.springdemo.service;

import org.springframework.stereotype.Service;

import com.hana7.springdemo.dao.UserDAO;
import com.hana7.springdemo.dto.User;

@Service
public class UserService {
	private final UserDAO repository;

	public UserService(UserDAO repository) {
		this.repository = repository;
	}

	public User getUser(int id) {
		return repository.getUser(id);
	}

	public void createUser(User user) {
		repository.insert(user);
	}
}