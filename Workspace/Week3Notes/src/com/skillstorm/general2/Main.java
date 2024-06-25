package com.skillstorm.general2;

public class Main {
	
	public static void main(String[] args) {
		Circle joe = new Circle("Joe", "Blue", 1);
		Circle bob = new Circle("Bob", "Orange", 2);
		Circle tom = new Circle("Tom", "Red", 3);
		Circle jack = new Circle("Joe", "Green", 1);
		
		System.out.println("**** Circle Joe *****");
		System.out.println("Joe's radius is: " + joe.radius());
		System.out.println("Joe's diameter is: " + joe.diameter());
		System.out.println("Joe's circumference is: " + joe.circumference());
		System.out.println("Joe's area is: " + joe.area());
		
		System.out.println();
		
		System.out.println("**** Circle Bob *****");
		System.out.println("Bob's radius is: " + bob.radius());
		System.out.println("Bob's diameter is: " + bob.diameter());
		System.out.println("Bob's circumference is: " + bob.circumference());
		System.out.println("Bob's area is: " + bob.area());
		
		System.out.println();
		
		System.out.println("**** Circle Tom *****");
		System.out.println("Tom's radius is: " + tom.radius());
		System.out.println("Tom's diameter is: " + tom.diameter());
		System.out.println("Tom's circumference is: " + tom.circumference());
		System.out.println("Tom's area is: " + tom.area());
		
		System.out.println();
		
		System.out.println("**** Circle Joe 2(Jack Reference)*****");
		System.out.println("Joe 2 radius is: " + jack.radius());
		System.out.println("Joe 2 diameter is: " + jack.diameter());
		System.out.println("Joe 2 circumference is: " + jack.circumference());
		System.out.println("Joe 2 area is: " + jack.area());
		
		System.out.println("\n\n\n");
		System.out.println("***** Circle Comparison *****");
		System.out.println("Joe is equal to Jack reference?\n"
				+ "Same name and same radius, so same Circle");
		System.out.println(joe.equals(jack));
		
		Circle myCircles[] = new Circle[4];
		myCircles[0] = joe;
		myCircles[1] = bob;
		myCircles[2] = tom;
		myCircles[3] = jack;
		
		System.out.println();
		System.out.println("\n\n\n***** myCircles[] Comparison *****");
		for(int i = 0; i < myCircles.length; i++) {
			
			for(int j = 0; j < myCircles.length; j++) {
				//int j = myCircles.length - 1; j > 1; j--
				
				System.out.println("Index: " + i + " " + myCircles[i].getClass());
				System.out.println("Index: " + j + " " + myCircles[j].getClass());
				
				if(myCircles[i].equals(myCircles[j])) {
					System.out.println("Same Circle");
				} else {
					System.out.println("Different Circle");
				}
				System.out.println();
			}
			
		}
		
		
	}

}
