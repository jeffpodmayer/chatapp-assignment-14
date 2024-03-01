package com.coderscampus.chatapp.a14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.domain.Message;
import com.coderscampus.chatapp.a14.service.ChannelService;
import com.coderscampus.chatapp.a14.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired 
	private ChannelService channelService;
	
	@PostMapping("/sendMessage/{channelId}")
	@ResponseBody
	public Message createNewMessage(@RequestBody Message message, @PathVariable Long channelId) {
		message = messageService.saveMessage(message);
		Channel channel = channelService.findByChannelId(channelId);
		channel.getMessages().add(message);
		System.out.println(channel);
		return message;
	}
	
	@GetMapping("/getNewMessages/{channelId}")
	public List<Message> getNewMessagesForChannel(@PathVariable Long channelId) {
		List<Message> messages = messageService.findMessagesByChannel(channelId);
		System.out.println(messages.toString());
		return messages;
	}
}
