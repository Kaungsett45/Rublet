package com.java.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
			int admin_id;
			String admin_username;
			String admin_password;
			
			
			public int getAdmin_id() {
				return admin_id;
			}
			public void setAdmin_id(int admin_id) {
				this.admin_id = admin_id;
			}
			public String getAdmin_username() {
				return admin_username;
			}
			public void setAdmin_username(String admin_username) {
				this.admin_username = admin_username;
			}
			public String getAdmin_password() {
				return admin_password;
			}
			public void setAdmin_password(String admin_password) {
				this.admin_password = admin_password;
			}
			
			
			
			
}
