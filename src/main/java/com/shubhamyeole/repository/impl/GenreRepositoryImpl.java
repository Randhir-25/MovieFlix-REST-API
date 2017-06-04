package com.shubhamyeole.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.shubhamyeole.entity.Genre;
import com.shubhamyeole.repository.GenreRepository;

@Repository
public class GenreRepositoryImpl implements GenreRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Genre> findAll() {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findAll", Genre.class);
		return query.getResultList();
	}


	@Override
	public Genre create(Genre genre) {
		em.persist(genre);
		return genre;
	}

	@Override
	public Genre findOne(String id) {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findById", Genre.class);
		query.setParameter("pId", id);
		List<Genre> genre = query.getResultList();
		
		if(genre!=null && genre.size()==1) return genre.get(0);
		return null;
	}

	@Override
	public void delete(Genre genre) {
		em.remove(genre);
	}

	@Override
	public Genre update(Genre genre) {
		return em.merge(genre);
	}

}
