package com.skillstorm.general;

public class Players {
	
	public enum Position{
		DEFENSE,
		MIDFIELD,
		FORWARD
	}
	
	private String name;
	private int number;
	private Position position;

	
	public Players() {}
	
	public Players(String name, int number, Position position) {
		this.name = name;
		this.number = number;
		this.position = position;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Number: %s , Position: %s%n", this.name, this.number, this.position);
		
	}
}
