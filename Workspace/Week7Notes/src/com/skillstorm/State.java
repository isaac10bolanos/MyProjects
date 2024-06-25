package com.skillstorm;

import java.util.ArrayList;

public class State {
	
	private String name;
	private City capital;
	private ArrayList<City> cities;
	
	public State() {
		
	}
	
	public State(String name, City capital, ArrayList<City> citites) {
		this.name = name;
		this.capital = capital;
		this.cities = new ArrayList<>(cities);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public City getCapital() {
		return this.capital;
	}
	
	public void setCapital(City capital) {
		this.capital = capital;
	}
	
	public ArrayList<City> getCities(){
		return new ArrayList<>(this.cities);
	}
	
	public void setCitites(ArrayList<City> citites) {
		this.cities = new ArrayList<>(cities);
	}

}
