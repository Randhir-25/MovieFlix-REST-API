package com.shubhamyeole.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Language {
	@Id
	@GenericGenerator(name="customUUId", strategy="uuid2")
	@GeneratedValue(generator="customUUId")
	private String id; //	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private String language;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
