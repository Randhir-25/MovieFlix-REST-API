package com.shubhamyeole.service;

import java.util.List;

import com.shubhamyeole.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findOne(String id);
	public User create(User User);
	public User update(User User);
	public void delete(String id);
}
