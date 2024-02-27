package com.coderscampus.chatapp.a14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.chatapp.a14.domain.User;
import com.coderscampus.chatapp.a14.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	@ResponseBody
	public User createNewUser(@RequestBody String username, HttpSession session) {
		User user = new User(username);
		userService.saveUser(user);
		session.setAttribute("username", username);
		session.setAttribute("userId", user.getUserId());
		System.out.println(user.toString());
		return user;
	}

	
	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		
		if(username == null) {
			return "redirect:/createUser";
		}
	
		return "welcome";
	}

}
