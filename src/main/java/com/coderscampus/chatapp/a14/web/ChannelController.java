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

import jakarta.servlet.http.HttpSession;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@PostMapping("/createChannel")
	@ResponseBody
	public Channel createNewChannel() {
		Channel channel = new Channel();
		channelService.saveChannel(channel);
		System.out.println(channel);
		return channel;
	}

	@GetMapping("/channel/{channelId}")
	public String viewChannelByChannelId(@PathVariable Long channelId, ModelMap model, HttpSession session) {
		Channel channel = channelService.findbyChannelId(channelId);
		String username = (String) session.getAttribute("username");
		session.setAttribute("username", username);
		model.put("channel", channel);
		model.put("username", username);
		
		System.out.println(channel);
		System.out.println(username);
		return "channel";
	}
	
	@PostMapping("/joinChannel/{channelId}")
    @ResponseBody
    public Channel joinChannel(@PathVariable Long channelId, ModelMap model) {
        Channel channel = channelService.findbyChannelId(channelId);
        if (channel == null) {
            channel = new Channel();
            channelService.saveChannel(channel);
        }

        System.out.println("Joined channel: " + channel);
        return channel;
    }
}
