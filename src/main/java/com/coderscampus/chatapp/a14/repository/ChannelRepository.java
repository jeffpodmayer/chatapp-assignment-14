package com.coderscampus.chatapp.a14.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.coderscampus.chatapp.a14.domain.Channel;

@Repository
public class ChannelRepository {

	private Map<Long, Channel> channels = new HashMap<>();

	public Channel save(Channel newChannel) {
		channels.put(newChannel.getChannelId(), newChannel);
		return newChannel;
	}
}
