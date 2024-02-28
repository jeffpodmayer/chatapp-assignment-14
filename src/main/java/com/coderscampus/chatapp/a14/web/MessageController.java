package com.coderscampus.chatapp.a14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.domain.Message;
import com.coderscampus.chatapp.a14.service.ChannelService;
import com.coderscampus.chatapp.a14.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private MessageService messageService;
	
	
	@PostMapping("/sendMessage/{channelId}")
	@ResponseBody
	public Message createNewMessage(Message message, @PathVariable Long channelId) {
		Channel channel = channelService.findbyChannelId(channelId);
		message = messageService.saveMessage(message);
		System.out.println(message);
		return message;
	}
}
