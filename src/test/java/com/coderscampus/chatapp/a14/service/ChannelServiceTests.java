package com.coderscampus.chatapp.a14.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.coderscampus.chatapp.a14.domain.Channel;
import com.coderscampus.chatapp.a14.repository.ChannelRepository;

@SpringBootTest
public class ChannelServiceTests {
	
	@Mock
	private ChannelRepository channelRepo;
	
	@InjectMocks
	private ChannelService channelService;
	
	@Test
	public void testCreateChannelAndChannelId() {
		Channel newChannel = new Channel(1L, "General");
		
		when(channelRepo.save(newChannel)).thenReturn(newChannel);
		Channel savedChannel = channelService.saveChannel(newChannel);
		
		assertNotNull(savedChannel);
		assertEquals("General", savedChannel.getChannelName());
		assertEquals(1L, savedChannel.getChannelId());
		assertNotNull(savedChannel.getChannelId());
		
	}
	
}

