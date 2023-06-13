package com.java.beans;



import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="movie_release")
public class movierelease {
		int release_date_id;
		String releasedate;
		public int getRelease_date_id() {
			return release_date_id;
		}
		public void setRelease_date_id(int release_date_id) {
			this.release_date_id = release_date_id;
		}
		public String getReleasedate() {
			return releasedate;
		}
		public void setReleasedate(String releasedate) {
			this.releasedate = releasedate;
		}
		
		
}
