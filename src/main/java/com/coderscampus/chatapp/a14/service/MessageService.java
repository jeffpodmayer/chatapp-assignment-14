package com.coderscampus.chatapp.a14.service;

import java.util.List;

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
	
	public List<Message> findMessagesForChannel(Long channelId) {
		return messageRepo.findMessagesByChannelId(channelId);
	}
	
	public Long assignMessageId() {
		return messageRepo.generateMessageId();
		
	}
}
