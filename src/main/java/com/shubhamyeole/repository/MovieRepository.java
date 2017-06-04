package com.shubhamyeole.repository;

import java.util.List;

import com.shubhamyeole.entity.Movie;

public interface MovieRepository {
	public List<Movie> findAll();
	public Movie findOne(String id);
	public Movie create(Movie movie);
	public void delete(Movie movie);
	Movie update(Movie movie);
}