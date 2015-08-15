package com.maolei.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.maolei.springmvc.mapping.Actor;
import com.maolei.springmvc.service.ActorService;
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class ActorServiceTest {
	@Resource
	private static ActorService userService = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		 Actor user = userService.getActorById(1);  
	        // System.out.println(user.getUserName());  
	        // logger.info("Öµ£º"+user.getUserName());  
		 System.out.println(user.getFirst_name());
	}

}
