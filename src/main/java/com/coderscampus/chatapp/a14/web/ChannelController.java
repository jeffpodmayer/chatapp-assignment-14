package com.coderscampus.chatapp.a14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.chatapp.a14.domain.Channel;
//import com.coderscampus.chatapp.a14.domain.Message;
import com.coderscampus.chatapp.a14.domain.User;
import com.coderscampus.chatapp.a14.service.ChannelService;
import com.coderscampus.chatapp.a14.service.UserService;
//import com.coderscampus.chatapp.a14.service.MessageService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@Autowired
	private UserService userService;
	
//	@Autowired
//	private MessageService messageService;

	@PostMapping("/createChannel")
	public Channel createNewChannel() {
		Channel channel = new Channel();
		channelService.saveChannel(channel);
		return channel;
	}
	
	@PostMapping("/joinOrCreateGeneralChannel")
	@ResponseBody
	public Channel joinOrCreateGeneralChannel(@RequestParam String username) {
		// Check if a channel exists
		Channel existingChannel = channelService.findByChannelId(1L);

		if (existingChannel == null) {

			// If no channel exists, create a new one;
			System.out.println("Creating a General Channel!");
			Channel newChannel = createNewChannel();

			// Add the user to the new channel
			User user = userService.findByUsername(username);
			newChannel.getUsers().add(user);

			System.out.println(newChannel.toString());

			return newChannel;

		} else {
			System.out.println("Adding a user to the General Channel.");
			User user = userService.findByUsername(username);
			existingChannel.getUsers().add(user);

			System.out.println(existingChannel.toString());
			return existingChannel;
		}
	}

	//GETS THE MODEL 
	@GetMapping("/channel/{channelId}")
	public String viewChannelByChannelId(@PathVariable Long channelId, ModelMap model) {
		Channel channel = channelService.findByChannelId(channelId);
		model.put("channel", channel);
		return "channel";
	}
	//POSTS THE CHANNEL DATA FROM THE JS: joinChannel(channelId) function
	@PostMapping("/joinChannel/{channelId}")
	@ResponseBody
	public Channel joinChannel(@RequestBody Channel channelData, @PathVariable Long channelId) {
		Channel channel = channelData;
		
		if (channel == null) {
			System.out.println(channel);
		}
		return channel;
	}
}
