package com.example.log.repository;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity	
public class bloo {
	//@EmbeddedId
	@Id
	@GeneratedValue
	int id;
	String theme;
	String email;
	int idd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//@Column(length = 10000) or
	@Lob
	String content;
	public int getIdd() {
		return idd;
	}
	public void setIdd(int idd) {
		this.idd = idd;
	}
	@Override
	public String toString() {
		return "bloo [id=" + id + ", theme=" + theme + ", email=" + email + ", idd=" + idd + ", content=" + content
				+ "]";
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
