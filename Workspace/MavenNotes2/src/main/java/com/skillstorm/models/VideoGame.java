package com.skillstorm.models;

public class VideoGame {
	
	private String title;
	private int airDate;
	private String platform;
	private int rating;
	private String category;
	
	public VideoGame() {}
	
	public VideoGame(String title, int airDate, String platform, int rating, String category) {
		this.title = title;
		this.airDate = airDate;
		this.platform = platform;
		this.rating = rating;
		this.category = category;
	}
	
	public boolean isRealeased(int year) {
		return this.airDate <= year;
		// it exist
	}
	
	public int getGameAge() {
		// how long ago was it released
		int year = 2023;
		int gameAge = year - this.airDate;
		return gameAge;
	}
	
	// only true in between 1-10
	public boolean validateRating(int rating) {
		if(rating >= 1 && rating <= 10) {
			return true;
		} else {
			return false;
		}
	} 

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAirDate() {
		return this.airDate;
	}

	public void setAirDate(int airDate) {
		this.airDate = airDate;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

}
