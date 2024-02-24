package com.coderscampus.chatapp.a14.domain;

public class Channel {
	private Long channelId;
	private String channelName;
	
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
	
	

}
