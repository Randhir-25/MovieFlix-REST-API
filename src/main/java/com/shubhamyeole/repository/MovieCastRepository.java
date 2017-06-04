package com.shubhamyeole.repository;

import java.util.List;

import com.shubhamyeole.entity.MovieCast;

public interface MovieCastRepository {
	public List<MovieCast> findAll();
	public MovieCast findOne(String id);
	public MovieCast create(MovieCast movieCast);
	public void delete(MovieCast movieCast);
	MovieCast update(MovieCast movieCast);
}
