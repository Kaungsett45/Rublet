package com.java.beans;


import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Entity
@Table (name="rating")
public class Rating {
	
	 int rating_id;
	 int star_rating;
	 String category_name;
	 String username;
	 int user_id;
	 int movie_id;
	 String comment_review;
	 String user_day;
	 String user_time;
	 String actor_name;
	 String actress_name;
	 String director_name;
	 Blob actor_image;
	 Blob actress_image;
	 Blob director_image;
	 
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getStar_rating() {
		return star_rating;
	}
	public void setStar_rating(int star_rating) {
		this.star_rating = star_rating;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getComment_review() {
		return comment_review;
	}
	public void setComment_review(String comment_review) {
		this.comment_review = comment_review;
	}
	public String getUser_day() {
		return user_day;
	}
	public void setUser_day(String user_day) {
		this.user_day = user_day;
	}
	public String getUser_time() {
		return user_time;
	}
	public void setUser_time(String user_time) {
		this.user_time = user_time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getActor_name() {
		return actor_name;
	}
	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}
	public String getActress_name() {
		return actress_name;
	}
	public void setActress_name(String actress_name) {
		this.actress_name = actress_name;
	}
	public String getDirector_name() {
		return director_name;
	}
	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}
	public Blob getActor_image() {
		return actor_image;
	}
	public void setActor_image(Blob actor_image) {
		this.actor_image = actor_image;
	}
	public Blob getActress_image() {
		return actress_image;
	}
	public void setActress_image(Blob actress_image) {
		this.actress_image = actress_image;
	}
	public Blob getDirector_image() {
		return director_image;
	}
	public void setDirector_image(Blob director_image) {
		this.director_image = director_image;
	}
	
	
	 
	
	
}
