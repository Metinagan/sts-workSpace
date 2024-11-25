package com.meetinagan.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.meetinagan.model.User;
import com.meetinagan.services.UserService;

@Configuration
public class AppConfig {

	@Bean
	public UserService UserService() {
		
		UserService userService=new UserService();
		List<User>userList=new ArrayList<>();
		userList.add(new User("Enes"));
		userList.add(new User("Bayram"));
		
		userService.setUserList(userList);
		
		return userService;
	}
	
}
