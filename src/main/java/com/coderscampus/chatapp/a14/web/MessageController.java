package com.coderscampus.chatapp.a14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.chatapp.a14.domain.Message;
import com.coderscampus.chatapp.a14.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("/sendMessage/{channelId}")
	@ResponseBody
	public Message createNewMessage(@RequestBody Message message, @PathVariable Long channelId) {
		message = messageService.saveMessage(message);
		System.out.println(message);
		return message;
	}
}
