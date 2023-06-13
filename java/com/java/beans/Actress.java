package com.java.beans;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="actress")
public class Actress {
	int actress_id;
	Blob actress_image;
	String actress_name;
	String about;
	String birth;
	int movie_id;
	public int getActress_id() {
		return actress_id;
	}
	public void setActress_id(int actress_id) {
		this.actress_id = actress_id;
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
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	
	
	
}
