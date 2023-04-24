package com.skillstorm.beans;

public class Users {
	private String name;
	private String email;
	private int phoneNumber;
	private int id;
	
	public Users() {}

	public Users(String name, String email, int phoneNumber, int id) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Email: %s, Phone number: %d, ID: %d",
				this.name, this.email, this.phoneNumber, this.id);
	}
	
	
}
