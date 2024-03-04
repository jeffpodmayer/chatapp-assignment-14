package com.coderscampus.chatapp.a14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.User;

@Repository
public class UserRepository {

	private List<User> users = new ArrayList<>();

	public User save(User user) {
		user.setUserId(generateUserId());
		users.add(user);
		return user;
	}

	public synchronized Long generateUserId() {
		return users.size() + 1L;
	}

	public User findByUsername(String username) {
		return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
	}

}
