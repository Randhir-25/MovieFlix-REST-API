package com.shubhamyeole.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.shubhamyeole.entity.Employee;
import com.shubhamyeole.entity.Movie;
import com.shubhamyeole.repository.EmployeeRepository;
import com.shubhamyeole.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}


	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie findOne(String id) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findById", Movie.class);
		query.setParameter("pId", id);
		List<Movie> movie = query.getResultList();
		
		if(movie!=null && movie.size()==1) return movie.get(0);
		return null;
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

}
