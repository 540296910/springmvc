package com.maolei.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.maolei.springmvc.pojo.User;

@Repository
public interface UserDao {
	public int addUser(User user);
	public User getUserByUsername(String username);
}
