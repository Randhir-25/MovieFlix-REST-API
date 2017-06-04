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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
//@Table(name="emp")
@NamedQueries({
	@NamedQuery(name="Movie.findAll", query="select e from Movie e order by id ASC"),
	@NamedQuery(name="Movie.findById", query="select e from Movie e WHERE e.id = :pId"),
})
public class Movie {
	@Id
	@GenericGenerator(name="customUUId", strategy="uuid2")
	@GeneratedValue(generator="customUUId")
	private String id; //	@GeneratedValue(strategy=GenerationType.AUTO)


	private String title;
	private int year;
	private String rated;
	private String released;
	private String runTime;
	private String plot;
	private String country;
	private String award;
	private String poster;
	private int metaStore;
	private double imdbRating;
	private double imdbVotes;
	private String imdbId;
	private String type;

	
	@OneToMany
	private List<Genre> genre;
	
	@OneToMany
	private List<MovieCast> movieCast;
	
	@OneToMany
	private List<Language> language;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public List<MovieCast> getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(List<MovieCast> movieCast) {
		this.movieCast = movieCast;
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

}
