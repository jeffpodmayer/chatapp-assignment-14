package com.coderscampus.chatapp.a14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.User;

@Repository
public class UserRepository {

	private List<User> users = new ArrayList<>();

	
	public User findById(Long userId) {
		return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
	}

	
	public User findByUsername(String username) {
		return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
	}

	
	public List<User> findAll() {
		return users;
	}

	
	public User save(User user) {
		users.add(user);
		return user;
	}

	public Long assignUserId() {
		return users.size() + 1L;
	}

}
