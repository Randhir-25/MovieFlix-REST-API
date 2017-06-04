package com.shubhamyeole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shubhamyeole.entity.Language;
import com.shubhamyeole.exception.EntityNotFoundException;
import com.shubhamyeole.repository.LanguageRepository;
import com.shubhamyeole.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {
	
	@Autowired
	LanguageRepository repository;
	
	@Override
	public List<Language> findAll() {
		return repository.findAll();
	}

	@Override
	public Language findOne(String id) {
		Language Language = repository.findOne(id);
		if(Language==null){
			throw new EntityNotFoundException("Language with "+id+" not found");
		}
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public Language create(Language Language) {
		return repository.create(Language);
	}

	@Override
	@Transactional
	public Language update(Language Language) {
		Language exist = repository.findOne(Language.getId());
		if(exist!=null){
			throw new EntityNotFoundException("Language with "+Language.getId()+" not found");
		}
		return repository.update(Language);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Language exist = repository.findOne(id);
		if(exist!=null){
			throw new EntityNotFoundException("Language with "+id+" not found");
		}
		repository.delete(exist);
	}
}
