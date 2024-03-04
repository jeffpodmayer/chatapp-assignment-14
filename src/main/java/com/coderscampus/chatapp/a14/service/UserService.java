package com.coderscampus.chatapp.a14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.chatapp.a14.domain.User;
import com.coderscampus.chatapp.a14.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public Long assignUserId() {
		return userRepo.generateUserId();
	}

	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
