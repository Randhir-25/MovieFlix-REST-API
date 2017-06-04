package com.shubhamyeole.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.shubhamyeole.entity.Language;
import com.shubhamyeole.repository.LanguageRepository;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Language> findAll() {
		TypedQuery<Language> query = em.createNamedQuery("Language.findAll", Language.class);
		return query.getResultList();
	}


	@Override
	public Language create(Language lang) {
		em.persist(lang);
		return lang;
	}

	@Override
	public Language findOne(String id) {
		TypedQuery<Language> query = em.createNamedQuery("Language.findById", Language.class);
		query.setParameter("pId", id);
		List<Language> lang = query.getResultList();
		
		if(lang!=null && lang.size()==1) return lang.get(0);
		return null;
	}

	@Override
	public void delete(Language lang) {
		em.remove(lang);
	}

	@Override
	public Language update(Language lang) {
		return em.merge(lang);
	}

}
