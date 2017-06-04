package com.shubhamyeole.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Genre {
	@Id
	@GenericGenerator(name="customUUId", strategy="uuid2")
	@GeneratedValue(generator="customUUId")
	private String id; //	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private String genreName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
}
