package com.shubhamyeole.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
//@Table(name="emp")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="select e from User e order by e.email ASC"),
	@NamedQuery(name="User.findByEmail", query="select e from User e WHERE e.email = :pEmail")
})
public class User {
	@Id
	@GenericGenerator(name="customUUId", strategy="uuid2")
	@GeneratedValue(generator="customUUId")
	private String uid; //	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private String fullName;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String type;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
