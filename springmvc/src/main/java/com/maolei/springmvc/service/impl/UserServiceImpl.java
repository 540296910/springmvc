package com.maolei.springmvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.maolei.springmvc.dao.UserDao;
import com.maolei.springmvc.pojo.User;
import com.maolei.springmvc.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.addUser(user);
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userDao.getUserByUsername(username);
	}

}
