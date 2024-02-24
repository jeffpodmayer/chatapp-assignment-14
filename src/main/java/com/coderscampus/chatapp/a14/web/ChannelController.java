package com.coderscampus.chatapp.a14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.domain.User;
import com.coderscampus.chatapp.a14.service.ChannelService;
import com.coderscampus.chatapp.a14.service.UserService;

@Controller
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/channel/1")
	public String getChannelByChannelId(ModelMap model, @PathVariable Long channelId) {
		User user = userService.findbyUserId(userId);
		Channel channel = new Channel();
		model.put("channel", channel);
		model.put("user", user);
		return "channel/" + channel.getChannelId();
	}
}
