package com.coderscampus.chatapp.a14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.domain.Message;
import com.coderscampus.chatapp.a14.repository.ChannelRepository;
import com.coderscampus.chatapp.a14.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired 
	private MessageRepository messageRepo;
	
	@Autowired 
	private ChannelRepository channelRepo;
	
	public Message saveMessage(Message message) {
		return messageRepo.save(message);
	}
	
	public List<Message> findMessagesForChannel(int channelId) {
		Channel channel = channelRepo.findByChannelId(channelId);
		return messageRepo.findMessagesByChannelId(channel);
	}
	
	public Long assignMessageId() {
		return messageRepo.generateMessageId();
		
	}
}
