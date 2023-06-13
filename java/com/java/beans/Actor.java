package com.java.beans;


import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;




@Entity
@Table(name="actor")
public class Actor {
		
		int actor_id;
		Blob actor_image;
		String actor_name;
		int movie_id;
		String about;
		String birth;
		
		public int getActor_id() {
			return actor_id;
		}
		public void setActor_id(int actor_id) {
			this.actor_id = actor_id;
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
		public int getMovie_id() {
			return movie_id;
		}
		public void setMovie_id(int movie_id) {
			this.movie_id = movie_id;
		}
		public String getAbout() {
			return about;
		}
		public void setAbout(String about) {
			this.about = about;
		}
		public String getBirth() {
			return birth;
		}
		public void setBirth(String birth) {
			this.birth = birth;
		}
		
		
		
}
