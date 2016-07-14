package com.maolei.springmvc.service.impl;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  

import com.maolei.springmvc.pojo.Actor;
import com.maolei.springmvc.service.ActorService;
  
  
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private ActorService userService = null;  
// git push test
// git ssh testssdfsd
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
    
    @Test  
    public void test1() {  
        Actor user = userService.get(1);  
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        System.out.println(user.getFirst_name());
        logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        logger.info(user.getFirst_name());  
    }  
}  