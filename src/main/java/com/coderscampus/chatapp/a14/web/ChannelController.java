package com.coderscampus.chatapp.a14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@PostMapping("/createChannel")
	@ResponseBody
	public Channel createNewChannel() {
		Channel channel = new Channel();
		channelService.saveChannel(channel);
		System.out.println(channel);
		return channel;
	}

	@GetMapping("/channel/{channelId}")
	public String viewChannelByChannelId(@PathVariable Long channelId, ModelMap model) {
		Channel channel = channelService.findbyChannelId(channelId);
		model.put("channel", channel);

		System.out.println(channel);
		return "channel";
	}

	@PostMapping("/joinChannel/{channelId}")
	@ResponseBody
	public Channel joinChannel(@PathVariable Long channelId, @PathVariable String username, ModelMap model) {
		Channel channel = channelService.findbyChannelId(channelId);
		User currentUser = userService.findByUsername(username);
		if (channel == null) {
			channel = new Channel();
			channelService.saveChannel(channel);
		}

		model.put("username", currentUser);

		System.out.println("Joined channel: " + channel);
		System.out.println("Channel username is: " + username);

		return channel;
	}
}
