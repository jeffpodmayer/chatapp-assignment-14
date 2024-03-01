package com.coderscampus.chatapp.a14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.Channel;

@Repository
public class ChannelRepository {

	private List<Channel> channels = new ArrayList<>();

	public Channel save(Channel newChannel) {
		newChannel.setChannelId(generateChannelId());
		newChannel.setUsers(new ArrayList<>());
        newChannel.setMessages(new ArrayList<>());
        channels.add(newChannel);
        System.out.println("Saved channel; " + newChannel.toString());
        System.out.println("Channels in the list are: " + channels.toString());
		return newChannel;
	}

	public Channel findByChannelId(Long channelId) {
		for (Channel channel : channels) {
			if (channel.getChannelId().equals(channelId));
			return channel;
		}
		return null;
	}
	
	public List<Channel> findAll() {
		return channels;
	}

	public synchronized Long generateChannelId() {
		return channels.size() + 1L;
	}
}
