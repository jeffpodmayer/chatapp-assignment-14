package com.coderscampus.chatapp.a14.domain;

import java.time.Instant;
import java.time.LocalDateTime;

public class Message {
	private Long messageId;
	private User sender;
	private Long channelId;
	private String messageBody;
	private Instant timestamp;

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", sender=" + sender + ", channelId=" + channelId + ", messageBody="
				+ messageBody + ", timestamp=" + timestamp + "]";
	}

	public Message(Long messageId, User sender, Long channelId, String messageBody, Instant timestamp) {
		super();
		this.messageId = messageId;
		this.sender = sender;
		this.channelId = channelId;
		this.messageBody = messageBody;
		this.timestamp = timestamp;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
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
