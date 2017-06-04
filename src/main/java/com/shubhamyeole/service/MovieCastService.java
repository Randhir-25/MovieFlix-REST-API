package com.shubhamyeole.service;

import java.util.List;

import com.shubhamyeole.entity.MovieCast;


public interface MovieCastService {
	public List<MovieCast> findAll();
	public MovieCast findOne(String id);
	public MovieCast create(MovieCast movieCast);
	public MovieCast update(MovieCast movieCast);
	public void delete(String id);
}
