package com.test.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.beans.User;

public interface UserService extends MongoRepository<User, Long> {

	User findOne(long id);

}
