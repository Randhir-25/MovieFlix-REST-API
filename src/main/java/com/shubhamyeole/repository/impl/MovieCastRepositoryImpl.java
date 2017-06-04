package com.shubhamyeole.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.shubhamyeole.entity.MovieCast;
import com.shubhamyeole.repository.MovieCastRepository;

@Repository
public class MovieCastRepositoryImpl implements MovieCastRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<MovieCast> findAll() {
		TypedQuery<MovieCast> query = em.createNamedQuery("MovieCast.findAll", MovieCast.class);
		return query.getResultList();
	}


	@Override
	public MovieCast create(MovieCast movieCast) {
		em.persist(movieCast);
		return movieCast;
	}

	@Override
	public MovieCast findOne(String id) {
		TypedQuery<MovieCast> query = em.createNamedQuery("MovieCast.findById", MovieCast.class);
		query.setParameter("pId", id);
		List<MovieCast> movieCast = query.getResultList();
		
		if(movieCast!=null && movieCast.size()==1) return movieCast.get(0);
		return null;
	}

	@Override
	public void delete(MovieCast movieCast) {
		em.remove(movieCast);
	}

	@Override
	public MovieCast update(MovieCast movieCast) {
		return em.merge(movieCast);
	}

}
