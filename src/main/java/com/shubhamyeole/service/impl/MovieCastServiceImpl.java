package com.shubhamyeole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shubhamyeole.entity.Movie;
import com.shubhamyeole.entity.MovieCast;
import com.shubhamyeole.exception.EntityNotFoundException;
import com.shubhamyeole.repository.MovieCastRepository;
import com.shubhamyeole.repository.MovieRepository;
import com.shubhamyeole.service.MovieCastService;
import com.shubhamyeole.service.MovieService;

@Service
public class MovieCastServiceImpl implements MovieCastService {

	@Autowired
	MovieCastRepository repository;
	
	@Override
	public List<MovieCast> findAll() {
		return repository.findAll();
	}

	@Override
	public MovieCast findOne(String id) {
		MovieCast emp = repository.findOne(id);
		if(emp==null){
			throw new EntityNotFoundException("MovieCast with "+id+" not found");
		}
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public MovieCast create(MovieCast moviecast) {
		return repository.create(moviecast);
	}

	@Override
	@Transactional
	public MovieCast update(MovieCast moviecast) {
		MovieCast exist = repository.findOne(moviecast.getCastid());
		if(exist!=null){
			throw new EntityNotFoundException("MovieCast with "+moviecast.getCastid()+" not found");
		}
		return repository.update(moviecast);
	}

	@Override
	@Transactional
	public void delete(String id) {
		MovieCast exist = repository.findOne(id);
		if(exist!=null){
			throw new EntityNotFoundException("MovieCast with "+id+" not found");
		}
		repository.delete(exist);
	}

}
