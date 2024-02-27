package com.coderscampus.chatapp.a14.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.chatapp.a14.domain.Message;
import com.coderscampus.chatapp.a14.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired 
	private MessageRepository messageRepo;
	
	public Message saveMessage(Message message) {
		return messageRepo.save(message);
	}
	
	public Map<Long, Message> findAllMessages() {
		return messageRepo.findAll();
	}
	public Message findByMessageId(Long messageId) {
		return messageRepo.findMessageById(messageId);
	}
	
	public Long assignMessageId() {
		return messageRepo.generateMessageId();
		
	}
}
