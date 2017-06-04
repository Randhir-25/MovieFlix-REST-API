package com.shubhamyeole.repository;

import java.util.List;

import com.shubhamyeole.entity.Language;

public interface LanguageRepository {
	public List<Language> findAll();
	public Language findOne(String id);
	public Language create(Language language);
	public void delete(Language language);
	Language update(Language language);
}
