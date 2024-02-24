package com.coderscampus.chatapp.a14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.domain.User;
import com.coderscampus.chatapp.a14.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model) {
		User user = new User();
		Channel channel = new Channel();
		model.put("channel", channel);
		model.put("user", user);
		return "welcome";
	}
	
	@PostMapping("/saveUser")
	@ResponseBody 
	public User postNewUser(@RequestBody String username) {
		User user = new User();
		user.setUsername(username);
		user.setUserId(userService.assignUserId(user));
		String userInfo = user.toString(); //remove when complete
		System.out.println(userInfo); //remove when complete
		user = userService.saveUser(user);
		return user;
	}
	
}
