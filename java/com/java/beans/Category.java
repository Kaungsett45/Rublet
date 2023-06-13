package com.java.beans;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="category")
public class Category {
		int category_id;
		String category_name;
		int movie_id;
		
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
		String movie_title;
		String description;
		String trailer;
		Blob movie_image;
		int actor_id;
		int actress_id;
		int director_id;
		int award_id;
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
		public int getCategory_id() {
			return category_id;
		}
		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}
		public String getCategory_name() {
			return category_name;
		}
		public void setCategory_name(String category_name) {
			this.category_name = category_name;
		}
		public int getMovie_id() {
			return movie_id;
		}
		public void setMovie_id(int movie_id) {
			this.movie_id = movie_id;
		}
		
		
		
}
