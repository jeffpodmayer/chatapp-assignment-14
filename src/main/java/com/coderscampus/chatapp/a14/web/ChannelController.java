package com.coderscampus.chatapp.a14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.domain.Message;
import com.coderscampus.chatapp.a14.domain.User;
import com.coderscampus.chatapp.a14.service.ChannelService;
import com.coderscampus.chatapp.a14.service.MessageService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@Autowired
	private MessageService messageService;

	@PostMapping("/createChannel")
	@ResponseBody
	public Channel createNewChannel(Channel channel) {
		channelService.saveChannel(channel);
		System.out.println("Saved channel: " + channel.toString());
		return channel;
	}

	@GetMapping("/channel/{channelId}")
	public String viewChannelByChannelId(@PathVariable Long channelId, ModelMap model) {
		Channel channel = channelService.findbyChannelId(channelId);
		model.put("channel", channel);
		System.out.println("You are on channel:" + channel);
		return "channel";
	}

	@PostMapping("/joinChannel/{channelId}")
	@ResponseBody
	public Channel joinChannel(@RequestBody Channel channelData, @PathVariable Long channelId) {
		Channel channel = channelService.findbyChannelId(channelId);
		List<User> username = channelData.getUsers();
		
		if (channel == null) {
			System.out.println(channel);
		}
		
		System.out.println("Joined channel: " + channel);
		System.out.println("Channel username is: " + username);

		return channel;
	}

	@GetMapping("/channel/getNewMessages/{channelId}")
	public List<Message> getNewMessagesForChannel(@PathVariable Long channelId) {
		List<Message> messages = messageService.findMessagesForChannel(channelId);
		System.out.println(messages.toString());
		return messages;
	}
}
