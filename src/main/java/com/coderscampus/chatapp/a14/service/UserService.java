package com.coderscampus.chatapp.a14.service;

import java.util.List;

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

	public Long assignUserId(User user) {
		List<User> usersList = userRepo.findAll();
		user.setUserId(usersList.size() + 1L);
		return user.getUserId();
	}

	public User findbyUserId(Long userId) {
		return userRepo.findById(userId);
	}

}
