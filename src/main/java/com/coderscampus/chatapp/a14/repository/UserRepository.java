package com.coderscampus.chatapp.a14.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.User;

@Repository
public class UserRepository {
	private Map<Long, User> users = new HashMap<>();

	public User save(User newUser) {
		users.put(newUser.getUserId(), newUser);
		return newUser;
	}
}
