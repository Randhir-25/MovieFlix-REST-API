package com.shubhamyeole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shubhamyeole.entity.Genre;
import com.shubhamyeole.entity.Movie;
import com.shubhamyeole.exception.EntityNotFoundException;
import com.shubhamyeole.repository.GenreRepository;
import com.shubhamyeole.repository.MovieRepository;
import com.shubhamyeole.service.GenreService;
import com.shubhamyeole.service.MovieService;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	GenreRepository repository;
	
	@Override
	public List<Genre> findAll() {
		return repository.findAll();
	}

	@Override
	public Genre findOne(String id) {
		Genre genre = repository.findOne(id);
		if(genre==null){
			throw new EntityNotFoundException("Genre with "+id+" not found");
		}
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public Genre create(Genre genre) {
		return repository.create(genre);
	}

	@Override
	@Transactional
	public Genre update(Genre genre) {
		Genre exist = repository.findOne(genre.getId());
		if(exist!=null){
			throw new EntityNotFoundException("Movie with "+genre.getId()+" not found");
		}
		return repository.update(genre);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Genre exist = repository.findOne(id);
		if(exist!=null){
			throw new EntityNotFoundException("Genre with "+id+" not found");
		}
		repository.delete(exist);
	}
}
