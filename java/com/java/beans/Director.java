package com.java.beans;


import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="director")
public class Director {
	
	int director_id;
	Blob director_image;
	String director_name;
	String about;
	String birth;
	public int getDirector_id() {
		return director_id;
	}
	public void setDirector_id(int director_id) {
		this.director_id = director_id;
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
