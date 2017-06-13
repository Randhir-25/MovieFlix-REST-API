package com.shubhamyeole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shubhamyeole.entity.User;
import com.shubhamyeole.exception.EntityNotFoundException;
import com.shubhamyeole.repository.UserRepository;
import com.shubhamyeole.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User User = repository.findOne(id);
		if(User==null){
			throw new EntityNotFoundException("User with "+id+" not found");
		}
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public User create(User User) {
		return repository.create(User);
	}

	@Override
	@Transactional
	public User update(User User) {
		User exist = repository.findOne(User.getUid());
		if(exist!=null){
			throw new EntityNotFoundException("User with "+User.getUid()+" not found");
		}
		return repository.update(User);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User exist = repository.findOne(id);
		if(exist!=null){
			throw new EntityNotFoundException("User with "+id+" not found");
		}
		repository.delete(exist);
	}
}
