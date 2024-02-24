package com.coderscampus.chatapp.a14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.service.ChannelService;
import com.coderscampus.chatapp.a14.service.UserService;

@Controller
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/channel/general")
	public String getGeneralChannel(ModelMap model) {
		Channel channel = new Channel();
		model.put("channel", channel);
		return "general-channel";
	}
}
