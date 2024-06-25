package com.skillstorm.general2;

public class Circle {
	
	private String name;
	private String color;
	private double radius;
	
	
	public Circle() {}
	
	public Circle(String name, String color, double radius) {
		this.name = name;
		this.color = color;
		this.radius = radius;
	}
	
	public double radius() {
		return radius;
		
	}
	
	public double diameter() {
		double diameter = 2 * radius;
		return diameter;
		
	}
	
	public double circumference() {
		double circumference = 2 * Math.PI * radius;
		return circumference;
		
	}
	
	public double area() {
		
		double area = Math.PI * (Math.pow(radius, 2));
		return area;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if(obj == null) {
			return false;
		} else if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Circle temp = (Circle)obj;
		
		return this.name.equals(temp.name)
			&& this.radius == temp.radius;
		
	}
	
	
	//@Override
	
	
//	public boolean equals(Object obj) {

//		if (this == obj) {
//			return true;
//		} else if (obj == null) {
//			return false;
//		} else if (this.getClass() != obj.getClass()) {
//			return false;
//		}
		

	
}
