package com.shubhamyeole.service;

import java.util.List;

import com.shubhamyeole.entity.Movie;

public interface MovieService {
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(String id);
}
