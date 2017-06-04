package com.shubhamyeole.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class MovieCast {
	@Id
	@GenericGenerator(name="customUUId", strategy="uuid2")
	@GeneratedValue(generator="customUUId")
	private String id; //	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private String personType;
	private String personName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
}
