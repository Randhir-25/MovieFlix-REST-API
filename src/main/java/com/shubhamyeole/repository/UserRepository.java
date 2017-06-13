package com.shubhamyeole.repository;

import java.util.List;

import com.shubhamyeole.entity.User;

public interface UserRepository {
	public List<User> findAll();
	public User findOne(String id);
	public User create(User user);
	public void delete(User user);
	User update(User user);
}