package com.skillstorm.general;

import java.util.ArrayList;

public class Programmer implements Comparable<Programmer>{
	
	private String name;
	private String company;
	private ArrayList<String> languages = new ArrayList<String>();
	
	public Programmer() {}
	
	public Programmer(String name, String company, String language) {
		this.name = name;
		this.company = company;
		languages.add(language);
		
	}
	
	public void addLanguage(String language) {
		if (!languages.contains(language) && language != null) {
		languages.add(language);
		
			} else if (language == null) {
				System.out.println("You cannot put null in a language.");
				
			}
		}
	
	
	public void removeLanguage(String language) {
		if (languages.contains(language)) {
			languages.remove(language);
		} else {
			System.out.println("You do not have that language.");
		}
		
	}
			
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		Programmer other = (Programmer)obj;
		return this.getName() == other.getName();
				
	}

	@Override
	public int compareTo(Programmer other) {
		
		String thisString = this.getCompany() + " " + this.getName();
		String otherString = other.getCompany() + " " + other.getName();
		return thisString.compareTo(otherString);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public ArrayList<String> getLanguages(){
		return this.languages;
	}
	
	@Override
	public String toString() {
		return "Programmer: " + this.name + ", Company: " + this.company + ", Language(s): " + this.languages + "\n";
	}

}

