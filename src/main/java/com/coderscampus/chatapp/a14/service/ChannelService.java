package com.coderscampus.chatapp.a14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;

	public Channel saveChannel(Channel channel) {
		return channelRepo.save(channel);
	}

	public Channel findByChannelId(Long channelId) {
		return channelRepo.findByChannelId(channelId);
	}

	public Long assignUserId() {
		return channelRepo.generateChannelId();

	}

	public List<Channel> findAll() {
		return channelRepo.findAll();
	}

}
