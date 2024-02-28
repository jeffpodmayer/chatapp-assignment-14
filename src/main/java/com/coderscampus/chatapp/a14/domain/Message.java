package com.coderscampus.chatapp.a14.domain;

import java.time.LocalDateTime;

public class Message {
	private Long messageId;
	private User sender;
	private Long channelId;
	private String messageBody;
	private LocalDateTime timeStamp;

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", sender=" + sender + ", channel=" + channelId + ", messageBody="
				+ messageBody + ", timeStamp=" + timeStamp + "]";
	}

	public Message(Long messageId, User sender, Long channelId, String messageBody, LocalDateTime timeStamp) {
		super();
		this.messageId = messageId;
		this.sender = sender;
		this.channelId = channelId;
		this.messageBody = messageBody;
		this.timeStamp = timeStamp;
	}

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

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannel(Long channelId) {
		this.channelId = channelId;
	}

}
