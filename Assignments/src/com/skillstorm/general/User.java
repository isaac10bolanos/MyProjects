package com.skillstorm.general;

public class User {

	// Variables
	private Long id;
	private String username;
	private String password;
	private boolean enabled;


	// Constructor
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.enabled = true;
	}

	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
