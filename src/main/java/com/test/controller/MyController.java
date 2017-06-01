package com.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.User;
import com.test.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class MyController {

	@Autowired
	private UserServiceImpl serviceImpl;
	Logger log = LoggerFactory.getLogger(MyController.class);

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void update(User user) {
		log.debug("create User method :" + user);
		serviceImpl.update(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findOne(@PathVariable("id") long id) {
		log.debug("get UserId : " + id);
		User user = serviceImpl.find(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> findAll() {
		log.debug("FindAll");
		return serviceImpl.findAll();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") long id) {
		log.debug("delete user ");
		serviceImpl.delete(id);

		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);

	}
}
