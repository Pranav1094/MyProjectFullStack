package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.beans.User;

@Service
public class UserServiceImpl {

	@Autowired
	private UserService userService;

	public void update(User user) {
		userService.save(user);
	}

	public User find(long id) {
		return userService.findOne(id);
	}

	public void delete(long id) {
		userService.delete(id);
	}

	public List<User> findAll() {
		return userService.findAll();

	}

}
