package com.maolei.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class IUserDetailService implements UserDetailsService{
	private static final Logger logger = Logger.getLogger(IUserDetailService.class);
	
	 @Resource  
	    private UserService userService;  
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		com.maolei.springmvc.pojo.User user = this.userService.getUserByUsername(username);
 		//为了测试方便，用户就写死了，真实环境可以查询数据库
	/*	String userlongid = "admin";
		
		String password = encode.encodePassword("654321", null);
		System.out.println("****************************");*/
//		Md5PasswordEncoder encode = new Md5PasswordEncoder();
//		String password = encode.encodePassword(user.getPassword(), user.getUsername());
		System.out.println("username="+user.getUsername()+";password="+user.getPassword());
//		System.out.println(password);
//		return new User(user.getUsername(),password, true, true,
//				true, true, authorities);
		return new User(user.getUsername(),user.getPassword(), true, true,
				true, true, authorities);
	}

}
