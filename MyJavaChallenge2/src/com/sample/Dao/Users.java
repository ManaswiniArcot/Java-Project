package com.sample.Dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table(name = "MY_USER")
public class Users implements Serializable{

	@Column(name ="FIRST_NAME")
	private String firstName;
	
	@Column(name ="LAST_NAME")
	private String lastName;
	
	@Id
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "profession")
	private String profession;
	@Column(name ="city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	
	@Column(name = "user_email")
	private String useremail;
	@Column(name = "Password")
	private String password;
	
	public String getProfession() {
		return profession;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
