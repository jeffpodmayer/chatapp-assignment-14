package com.coderscampus.chatapp.a14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.User;

@Repository
public class UserRepository {
	private List<User> users = new ArrayList<>();

	public User save(User newUser) {
		users.add(newUser);
		return newUser;
	}
}
