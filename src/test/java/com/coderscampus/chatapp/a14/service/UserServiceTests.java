package com.coderscampus.chatapp.a14.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.coderscampus.chatapp.a14.domain.User;
import com.coderscampus.chatapp.a14.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {
	
	@Mock
	private UserRepository userRepo;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void testCreateUser() {
		User newUser = new User(1L, "Jeff");
		
		when(userRepo.save(newUser)).thenReturn(newUser);
		User savedUser = userService.saveUser(newUser);
		
		assertNotNull(savedUser);
		assertEquals("Jeff", savedUser.getUsername());
		assertNotNull(savedUser.getUserId());
		
	}
	
}
