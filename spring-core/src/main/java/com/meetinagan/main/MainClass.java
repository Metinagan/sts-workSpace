package com.meetinagan.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.meetinagan.config.AppConfig;
import com.meetinagan.model.User;
import com.meetinagan.services.UserService;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService=context.getBean(UserService.class);
		
		for(User user:userService.getUserList()) {
			System.out.println(user);
		}
		

	}

}
