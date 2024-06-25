package com.skillstorm.general;

import com.skillstorm.beans.BengalTiger;
import com.skillstorm.beans.Cat;
import com.skillstorm.beans.Ragdoll;
import com.skillstorm.beans.Tiger;

public class CatFarm {
	
	public final static boolean ANIMAL = true;
	
	public static void main(String[] args) {
		
		System.out.println(ANIMAL);
		
		CatFarm denverFarm = new CatFarm();
		
		denverFarm.catPark();
	}
	
	public void catPark() {
		System.out.println("***** Mark *******");
		Cat mark = new Cat("Mark", 18, true, "Yellow", true);
		
		mark.speak();
		mark.sleep(16);
		mark.swim();
		mark.hunt();
		mark.go(15);
		
		System.out.println("***** Joe *******");
		Ragdoll joe = new Ragdoll("Joe", 15, true, "Blue", true);
		
		joe.speak();
		joe.sleep(15);
		joe.swim();
		joe.hunt();
		joe.go(25);
		joe.affection();
		
		System.out.println("***** Bill *******");
		Tiger bill = new Tiger("Bill", 20, false, "Golden", false);
		
		bill.speak();
		bill.sleep(18);
		bill.swim();
		bill.hunt();
		bill.go(35);
		
		System.out.println("***** Bryan *******");
		BengalTiger bryan = new BengalTiger("Bryan", 25, false, "Amber", false);
		
		bryan.speak();
		bryan.sleep(20);
		bryan.swim();
		bryan.hunt();
		bryan.go(40);
	}

}
