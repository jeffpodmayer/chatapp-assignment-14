package com.coderscampus.chatapp.a14.service;

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
	
	public Channel findbyChannelId(Long channelId) {
		return channelRepo.findByChannelId(channelId);
	}
	
	public Channel findByChannelName(String channelName) {
		return channelRepo.findByChannelName(channelName);
	}
	
	public Long assignUserId() {
		return channelRepo.generateChannelId();
		
	}
	
}
