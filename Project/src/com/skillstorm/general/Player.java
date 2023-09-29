package com.skillstorm.general;

public abstract class Player {
	// Let's compare changes to this branch
	
	private String name;
	private String type;
	private int force;
	private String weapon;
	
	public Player() {}
	
	public Player(String name, String type,
			int force, String weapon) {
		this.name = name;
		this.type = type;
		this.force = force;
		this.weapon = weapon;
	}
	
	// methods my characters will implement
	public abstract void badEndPlayer();
	
	public abstract void okayEndPlayer();
	
	public abstract void goodEndPlayer();
	
	public abstract void remember();
	
	public abstract void simple();
	
	public abstract void oneWithForce();
	
	public abstract void feeling();
	
	public abstract void clever();
	
	public abstract void pass();
	
	public abstract void strong();
	
	public abstract void right();
	
	public abstract void twist();
	
	public abstract void twisted();
	
	public abstract void size();
	
	public abstract void small();
	
	public abstract void quote();
	
	public abstract void speak();
	
	public abstract void force();
	
	public void chosen() {
		System.out.println("\"You were the Chosen ONE!\"");
	} // used in goodEnd scene
	
	public void waiting() {
		System.out.println("\"I've been waiting for you, " + name + 
				". We meet again, at last.\"");
		// used in lady scene
	}
	
	public void high() {
		System.out.println("\"I have the high ground.\"");
		// used in alien scene
	}
	
	public void fuzzball() {
		System.out.println("\"Laugh it up, fuzzball.\"");
		// used in okayEnd scene
	}
	
	// used in chest scene
	public void useForce() {
		System.out.println("Use the Force, " + UserLogic.name + ". Let go.");
	}
	
	public void withYou() {
		System.out.println("May the Force be with you.");
		// used in door scene
	}
	
	// used in GoodEnd scene
	public void great() {
		System.out.println("Great " + name + ", don't get cocky."); // han solo quote
	}
	
	// used in Bad end scene
	public void requested() {
		System.out.println("\"Sometimes we must let go of our pride and do what is requested of us.\"");
	}
	
	
	// used in Okay End scene
	public void gone() {
		System.out.println("\"No one's ever really gone.\"");
	} // luke quote
	
	
	// yes for Bad end scene
	public void another() {
		System.out.println("\"That boy is our last hope. No. There is another.\"");
	} // good for conclusion
	
	// used in rancor scene
	public void embarrased() {
		System.out.println("I'm rather embarrassed, " + UserLogic.name + ", but it appears that\n"
				+ "you are to be the main course at a banquet in my honor."); // C-3P0 quote
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getForce() {
		return this.force;
	}
	
	public void setForce(int force) {
		this.force = force;
	}
	
	public String getWeapon() {
		return this.weapon;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	@Override
	public String toString() {
		return String.format("Player traits:\n\nJedi type: %s\nForce level: %d\nJedi weapon: %s\n",
				this.type, this.force, this.weapon);
		// good to display character
	}
	
	// not sure if I need these but keep them just in case
//	public void status() {
//		Logic.printHeading(type + " " + name + "\n" + "\nforce level: " + force +
//			
//			"\nweapon: " + weapon);
//	}
	
//	public void badForce() {
//		force = force - 1;
//		System.out.println("That was not very good, current knowlege of the force " + force);
//	}

//	public void goodForce() {
//		force = force + 1;
//		System.out.println("Well done, current knowledge of the force " + force);
//	}

//	public void attack() {
//		System.out.println(name + " attacked with his " + type);
//	}

//	public void goodChoice() {
//		this.force = force + 2;
//		System.out.println("Your wise and strategic, current level knowledge of the force " + force);
//	}

//	public void badChoice() {
//		this.force = force + 2;
//		System.out.println("That was not a very good strategy even with your expertise,\n"
//			+ "current knowledge of the force " + force);
//	}


}

	
	


