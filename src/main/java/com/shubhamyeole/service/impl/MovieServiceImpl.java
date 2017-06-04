package com.shubhamyeole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shubhamyeole.entity.Movie;
import com.shubhamyeole.exception.EntityNotFoundException;
import com.shubhamyeole.repository.MovieRepository;
import com.shubhamyeole.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepository repository;
	
	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findOne(String id) {
		Movie movie = repository.findOne(id);
		if(movie==null){
			throw new EntityNotFoundException("Movie with "+id+" not found");
		}
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(Movie movie) {
		Movie exist = repository.findOne(movie.getId());
		if(exist!=null){
			throw new EntityNotFoundException("Movie with "+movie.getId()+" not found");
		}
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie exist = repository.findOne(id);
		if(exist!=null){
			throw new EntityNotFoundException("Movie with "+id+" not found");
		}
		repository.delete(exist);
	}
}
