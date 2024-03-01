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
	
//	public User findbyUserId(Long userId) {
//		return userRepo.findById(userId);
//	}
//	
//	public User findByUsername(User sender) {// DUPLICATE
//		return userRepo.findByUsername(sender);
//	}
	
//	public User findByUsername(String username) { //DUPLICATE
//		// TODO Auto-generated method stub
//		return userRepo.findByUsername(username);
//	}
}
