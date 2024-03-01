package com.coderscampus.chatapp.a14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.User;

@Repository
public class UserRepository {

	private List<User> users = new ArrayList<>();

//	public User findById(Long userId) {
//		return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst().orElse(null);
//	}
//
//	public User findByUsername(User sender) {//DUPLICATE
//		return users.stream().filter(user -> user.getUsername().equals(sender)).findFirst().orElse(null);
//	}
//
//	public List<User> findAll() {
//		return users;
//	}

	public User save(User user) {
		user.setUserId(generateUserId());
		users.add(user);
		System.out.print("Users in the list are: " + users.toString());	
		return user;
	}

	public synchronized Long generateUserId() {
		return users.size() + 1L;
	}

	public User findByUsername(String username) { //DUPLICATE
		return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
	}

}
