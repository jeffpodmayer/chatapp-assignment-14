package com.coderscampus.chatapp.a14.domain;

import java.util.List;

public class Channel {
	private Long channelId;
	private String channelName;
	private List<User> users;
	private List<Message> messages;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Channel(Long channelId, String channelName) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
	}

	public Channel() {
	}

	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName=" + channelName + "]";
	}
}
