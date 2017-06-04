package com.shubhamyeole.service;

import java.util.List;

import com.shubhamyeole.entity.Genre;

public interface GenreService {
	public List<Genre> findAll();
	public Genre findOne(String id);
	public Genre create(Genre genre);
	public Genre update(Genre genre);
	public void delete(String id);
}
