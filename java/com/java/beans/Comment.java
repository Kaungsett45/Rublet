package com.java.beans;


import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="comment")
public class Comment {
	int comment_id;
	int user_id;
	String usercomment;
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsercomment() {
		return usercomment;
	}
	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}
	
	
}
