package com.java.beans;





import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;







@Entity
@Table(name="Movie")
public class Movie {
	int movie_id;
	String movie_title;
	String description;
	String trailer;
	Blob movie_image;
	int category_id;
	int actor_id;
	int actress_id;
	int director_id;
	int award_id;
	String releasedate;
	String category_name;
	Blob actor_image;
	String actor_name;

	Blob actress_image;
	String actress_name;
	String award_name;

	Blob director_image;
	String director_name;
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public Blob getMovie_image() {
		return movie_image;
	}
	public void setMovie_image(Blob movie_image) {
		this.movie_image = movie_image;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public int getActress_id() {
		return actress_id;
	}
	public void setActress_id(int actress_id) {
		this.actress_id = actress_id;
	}
	public int getDirector_id() {
		return director_id;
	}
	public void setDirector_id(int director_id) {
		this.director_id = director_id;
	}
	public int getAward_id() {
		return award_id;
	}
	public void setAward_id(int award_id) {
		this.award_id = award_id;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Blob getActor_image() {
		return actor_image;
	}
	public void setActor_image(Blob actor_image) {
		this.actor_image = actor_image;
	}
	public String getActor_name() {
		return actor_name;
	}
	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}
	public Blob getActress_image() {
		return actress_image;
	}
	public void setActress_image(Blob actress_image) {
		this.actress_image = actress_image;
	}
	public String getActress_name() {
		return actress_name;
	}
	public void setActress_name(String actress_name) {
		this.actress_name = actress_name;
	}
	public String getAward_name() {
		return award_name;
	}
	public void setAward_name(String award_name) {
		this.award_name = award_name;
	}
	public Blob getDirector_image() {
		return director_image;
	}
	public void setDirector_image(Blob director_image) {
		this.director_image = director_image;
	}
	public String getDirector_name() {
		return director_name;
	}
	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}
	
	
	 
	 
	 
}
