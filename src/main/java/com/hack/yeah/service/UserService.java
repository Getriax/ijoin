package com.hack.yeah.service;

import com.hack.yeah.model.User;

public interface UserService{
	void save(User user);
	User findByUsername(String username);
	User findByEmail(String email);
}
