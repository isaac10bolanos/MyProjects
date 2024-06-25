package com.skillstorm.general;

import java.util.Comparator;

public class Cars {
	
	private String make;
	private String model;
	private String color;
	
	public Cars() {}
	
	public Cars(String make, String model, String color) {
		this.make = make;
		this.model = model;
		this.color = color;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return String.format("Color: %s, Make: %s, Model: %s", color, make, model);		
		
	}
	
	public class CarsComparator2 implements Comparator<Cars> {

		@Override
		public int compare(Cars cars1, Cars cars2) {
			// order by make && model
			String thisCar = cars1.getMake() + " " + cars1.getModel();
			String otherCar = cars2.getMake() + " " + cars2.getModel();
			return thisCar.compareTo(otherCar);	
		}
		
	}
	
	public static class CarsComparator implements Comparator<Cars> {
		
		@Override
		public int compare(Cars o1, Cars o2) {
			// order by color
			return o1.getColor().compareTo(o2.getColor());
		}
		
//		public int compare1(Cars i1, Cars i2) {
//			return i1.getMake().compareTo(i2.getMake());
//		}
	}

}
