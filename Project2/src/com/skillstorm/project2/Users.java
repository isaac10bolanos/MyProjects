package com.skillstorm.project2;

public class Users {
	private String name;
	private String email;
	private long phoneNumber;
	private long id;
	
	public Users() {}

	public Users(String name, String email, long phoneNumber, long id) {
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Email: %s, Phone number: %d, ID: %d",
				this.name, this.email, this.phoneNumber, this.id);
	}
	
	
}