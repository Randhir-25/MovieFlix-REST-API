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
	@NamedQuery(name="Employee.findAll", query="select e from Employee e order by e.email ASC"),
	@NamedQuery(name="Employee.findByEmail", query="select e from Employee e WHERE e.email = :pEmail")
})
public class Employee {
	@Id
	@GenericGenerator(name="customUUId", strategy="uuid2")
	@GeneratedValue(generator="customUUId")
	private String id; //	@GeneratedValue(strategy=GenerationType.AUTO)

	
	private String fname;
	
	private String lname;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
