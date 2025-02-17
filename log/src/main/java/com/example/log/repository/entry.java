package com.example.log.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class entry {
	@Id
	@GeneratedValue
	int id;
	private String fname;
	private String email;
	private String pass;
	//private String conpass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	/*public void setConpass(String conpass) {
		this.conpass = conpass;
	}*/
	@Override
	public String toString() {
		return "user [id=" + id + ", fname=" + fname + ", email=" + email + ", pass=" + pass+ "]";
	}

}
