package com.coderscampus.chatapp.a14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.User;

@Repository
public class UserRepository {
	private List<User> users = new ArrayList<>();

	public User save(User newUser) {
		users.add(newUser);
		return newUser;
	}

	public List<User> findAll() {
		return users;
	}

	public User findById(Long userId) {
		Optional<User> userOptional = users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst();

		return userOptional.orElse(null);
	}
}
