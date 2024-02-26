package com.coderscampus.chatapp.a14.domain;

public class User {
	private static Long nextUserId = 1L;
	
	private Long userId;
	private String username;

	public User(String username) {
		super();
		this.userId = generateUserId();
		this.username = username;
	}
	
	private static synchronized long generateUserId() {
        return nextUserId++;
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}

}
