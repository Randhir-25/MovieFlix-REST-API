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
	private String castid; //	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int metaStore;
	private double imdbRating;
	private double imdbVotes;
	private String imdbId;
	public String getCastid() {
		return castid;
	}
	public void setCastid(String castid) {
		this.castid = castid;
	}
	public int getMetaStore() {
		return metaStore;
	}
	public void setMetaStore(int metaStore) {
		this.metaStore = metaStore;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public double getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(double imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	
	
}
