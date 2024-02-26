package com.coderscampus.chatapp.a14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.coderscampus.chatapp.a14.repository.InMemoryUserRepository;
import com.coderscampus.chatapp.a14.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
