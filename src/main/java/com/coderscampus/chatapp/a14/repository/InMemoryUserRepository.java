package com.coderscampus.chatapp.a14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.User;

@Repository
public class InMemoryUserRepository implements UserRepository {

	List<User> users = new ArrayList<>();
	
	@Override
	public User findById(Long userId) {
		return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
	}

	@Override
	public User findByUsername(String username) {
		return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public User save(User user) {
		user.setUserId(assignUserId());
		users.add(user);
		return user;
	}
	
	public Long assignUserId() {
		return users.size() + 1L;
	}

	
}
