package com.coderscampus.chatapp.a14.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.Message;

@Repository
public class MessageRepository {

	private Map<Long, Message> messages = new HashMap<>();

	public Message save(Message message) {
		message.setMessageId(generateMessageId());
		messages.put(message.getMessageId(), message);
		return message;
	}
	
	public Map<Long, Message> findAll() {
		return messages;
	}

	public Message findMessageById(Long messageId) {
		return messages.get(messageId);
	}

	public synchronized Long generateMessageId() {
		return messages.size() + 1L;
	}
}
