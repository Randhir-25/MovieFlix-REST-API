package com.shubhamyeole.repository;

import java.util.List;

import com.shubhamyeole.entity.Genre;

public interface GenreRepository {
	public List<Genre> findAll();
	public Genre findOne(String id);
	public Genre create(Genre genre);
	public void delete(Genre genre);
	Genre update(Genre genre);
}
