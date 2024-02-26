package com.coderscampus.chatapp.a14.domain;

import java.time.LocalDateTime;

public class Message {
	private Long messageId;
	private User sender;
	private Channel channel;
	private String messageBody;
	private LocalDateTime timeStamp;

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Message [sender=" + sender + ", messageBody=" + messageBody + ", timeStamp=" + timeStamp + "]";
	}

	public Message(User sender, String messageBody, LocalDateTime timeStamp) {
		super();
		this.sender = sender;
		this.messageBody = messageBody;
		this.timeStamp = timeStamp;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	

}
