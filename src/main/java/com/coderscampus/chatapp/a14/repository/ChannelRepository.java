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
		channels.add(newChannel);
		return newChannel;
	}

	public Channel findByChannelId(int channelId) {
		return channels.get(channelId);
	}

	public synchronized Long generateChannelId() {
		return channels.size() + 1L;
	}
}
