package com.coderscampus.chatapp.a14.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.coderscampus.chatapp.a14.domain.User;
import com.coderscampus.chatapp.a14.repository.ChannelRepository;
import com.coderscampus.chatapp.a14.repository.UserRepository;

@SpringBootTest
public class ChannelServiceTests {
	
	@Mock
	private ChannelRepository channelRepo;
	
	@InjectMocks
	private ChannelService channelService;
	
	@Test
	public void testCreateChannel() {
		User newChannel = new Channel(1L, "General");
		
		when(channelRepo.save(newChannel)).thenReturn(newChannel);
		User savedChannel = channelService.saveUser(newChannel);
		
		assertNotNull(savedChannel);
		assertEquals("General", savedChannel.getChannelName());
		assertNotNull(savedChannel.getChannelId());
		
	}
	
}

