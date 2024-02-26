package com.coderscampus.chatapp.a14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.service.ChannelService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@PostMapping("/createChannel/{channelName}")
	@ResponseBody
	public Channel createNewChannel(@PathVariable String channelName, ModelMap model) {
		Channel channel = new Channel();
		channel.setChannelName(channelName);
		channelService.saveChannel(channel);

		Long channelId = channel.getChannelId();
		model.put("channelId", channelId);

		System.out.println(channel.toString());
		return channel;
	}

	@GetMapping("/channel/{channelId}")
	public String viewChannelByChannelId(@PathVariable Long channelId, ModelMap model) {
		Channel channel = channelService.findbyChannelId(channelId);
		model.put("channel", channel);
		return "channel";
	}
}
