package com.coderscampus.chatapp.a14.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.User;

@Repository
public interface UserRepository {

	User findById(Long userId);
	User findByUsername(String username);
	List<User> findAll();
	User save(User user);
	
}
