package com.java.beans;


import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;




@Entity
@Table(name="Award")
public class Award {
			int award_id;
			String award_name;
			int movie_id;
			public int getAward_id() {
				return award_id;
			}
			public void setAward_id(int award_id) {
				this.award_id = award_id;
			}
			public String getAward_name() {
				return award_name;
			}
			public void setAward_name(String award_name) {
				this.award_name = award_name;
			}
			public int getMovie_id() {
				return movie_id;
			}
			public void setMovie_id(int movie_id) {
				this.movie_id = movie_id;
			}
			
			
			
}
