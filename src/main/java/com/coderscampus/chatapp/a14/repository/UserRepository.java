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

	public User findByUsername(User sender) {
		return users.stream().filter(user -> user.getUsername().equals(sender)).findFirst().orElse(null);
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		user.setUserId(generateUserId());
		users.add(user);
		return user;
	}

	public synchronized Long generateUserId() {
		return users.size() + 1L;
	}

}
