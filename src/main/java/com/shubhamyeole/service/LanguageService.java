package com.shubhamyeole.service;

import java.util.List;

import com.shubhamyeole.entity.Language;

public interface LanguageService {
	public List<Language> findAll();
	public Language findOne(String id);
	public Language create(Language language);
	public Language update(Language language);
	public void delete(String id);
}
