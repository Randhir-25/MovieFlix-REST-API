package com.shubhamyeole.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.shubhamyeole.entity.User;
import com.shubhamyeole.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}


	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User findOne(String id) {
		TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
		query.setParameter("pId", id);
		List<User> user = query.getResultList();
		
		if(user!=null && user.size()==1) return user.get(0);
		return null;
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

}
