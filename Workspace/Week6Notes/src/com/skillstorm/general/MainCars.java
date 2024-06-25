package com.skillstorm.general;

import java.util.ArrayList;
import java.util.Arrays;

import com.skillstorm.general.Cars.CarsComparator2;

public class MainCars {
	
	public static void main(String[] args) {
		
		Cars[] carArray = new Cars[] { new Cars("Mitsubishi", "Lancer EVO", "White"),
				new Cars("Nissan", "Skyline GT-R", "Blue"), new Cars("Mazda", "RX-7", "Orange") };
		
		ArrayList<Cars> cars = new ArrayList<>(Arrays.asList(carArray));
		
		System.out.println(cars);
		
		Cars.CarsComparator comparator = new Cars.CarsComparator();
		cars.sort(comparator);
		System.out.println(cars);
	
		CarsComparator2 comparator2 = new Cars().new CarsComparator2();
		
		cars.sort(comparator2);
		System.out.println(cars);
		
	}
}







