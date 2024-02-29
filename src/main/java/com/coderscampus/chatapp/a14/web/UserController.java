package com.coderscampus.chatapp.a14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.chatapp.a14.domain.User;
import com.coderscampus.chatapp.a14.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	@ResponseBody
	public User createNewUser(@RequestBody String username) {
		User user = new User(username);
		userService.saveUser(user);
		System.out.println("Saved user: " + user.toString());
		return user;
	}

	@GetMapping("/welcome")
	public String getWelcomePage() {
		return "welcome";
	}

}
