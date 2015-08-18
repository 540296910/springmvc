package com.maolei.springmvc.service;

import com.maolei.springmvc.pojo.User;

public interface UserService {
	public int addUser(User user);
	public User getUserByUsername(String username);
}
