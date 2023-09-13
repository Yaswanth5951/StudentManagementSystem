package com.um.model;

public class User {

	public int id;
	public String Name;
	public String Email; 
	public String City;
	public User(String name, String email, String city) {
		super();
		Name = name;
		Email = email;
		City = city;
	}
	public User(int id, String name, String email, String city) {
		super();
		this.id = id;
		Name = name;
		Email = email;
		City = city;
	}
	public User() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	
}
