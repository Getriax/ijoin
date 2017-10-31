package com.app.ijoin.service;

import com.app.ijoin.model.User;

public interface UserService{
	void save(User user);
	User findByUsername(String username);
	User findByEmail(String email);
}
