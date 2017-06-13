package com.shubhamyeole.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

public class MovieTemp2 {

	private MovieTemp movTemp;

	public MovieTemp getMovTemp() {
		return movTemp;
	}

	public void setMovTemp(MovieTemp movTemp) {
		this.movTemp = movTemp;
	}
	
}
