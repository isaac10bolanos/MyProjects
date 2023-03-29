package com.skillstorm.general;

public class Master extends Player{
	
public Master() {}
	
	public Master(String name, String type,
			int force, String weapon) {
		super(name, type, force, weapon);
	}
	
	@Override
	public void remember() {
		System.out.println("The force was not used to detect what was inside.\n");
		System.out.println("\"In a dark place we find ourselves,\n"
				+ "and a little more knowledge lights our way.\"");
		super.setForce(getForce() - 1);
		// System.out.println(getForce());
		// used in chest scene (option 1)
		
	}
	
	@Override
	public void simple() {
		System.out.println("Fear has awakened in you.\n");
		System.out.println("\"Fear is the path to the dark side.\"");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in chest scene (option 2)
		
	}
	
	@Override
	public void oneWithForce() {
		System.out.println("What is unknown has been kept from you by your faith in the force.\n");
		System.out.println("\"I'm one with the Force. The Force is with me.\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// blind man walking through blasts
		// used in chest scene (option 3)
	}
	
	@Override
	public void small() {
		System.out.println("\"Fear leads to anger, anger leads to hate,"
				+ " hate leads to suffering.\"");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in alien scene (option 2)
		
	}
	
	@Override
	public void clever() {
		System.out.println("You're very clever, did you see that somewhere?\n");
		System.out.println("\"Would somebody get his big walking carpet out of my way!\"");
		super.setForce(getForce() + 1);
		// System.out.println(getForce());
		// used in rancor scene (option 2)
		
	}
	
	@Override
	public void quote() {
		System.out.println("When using the force, you know precisely when to act.\n");
		System.out.println("\"Do or do not. There is no try.\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// used in rancor scene (option 3)
	}
	
	@Override
	public void force() {
		System.out.println("With time not on your side, you made a bad decision.\n");
		System.out.println("\"Never tell me the odds.\""); // han solo
		super.setForce(getForce() - 1);
		// System.out.println(getForce());
		// used in lady scene (option 3)
	}
	
	@Override
	public void speak() {

		System.out.println(UserLogic.name + ", the Force runs strong in your family.");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// used in lady scene (option 1)
	}
	
	@Override
	public void pass() {
		System.out.println("Never turn down a helpless woman in need"
				+ " of assistance.\n");
		System.out.println("\"Control, control, you must learn control.\"");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in lady scene (option 2)
	}
	
	@Override
	public void strong() {
		System.out.println("The Force is strong with this one. Good job " + UserLogic.name + "!");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// used in door scene (option 3)
	}
	
	@Override
	public void right() {
		System.out.println("If you had used Force, you would have known that\n"
				+ "at the entry of that door was evil.\n");
		System.out.println("\"Once you start down the dark path,\n"
				+ "forever will it dominate your destiny.\"");
		super.setForce(getForce() - 1);
		// System.out.println(getForce());
		// used in door scene (option 1)
		
	}
	
	@Override
	public void twist() {
		System.out.println("\"When you look at the dark side, careful you must be.\n"
				+ "For the dark side looks back\"");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in door scene (option 2)
		
	}
	
	@Override
	public void feeling() {
		System.out.println("Twisted by the dark side, young " + UserLogic.name +
				" has become.");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in rancor scene (option 1)
	}
	
	@Override
	public void size() {
		System.out.println("\"Size matters not. Look at me.\n"
				+ "Judge me by my size, do you? Hmm? Hmm.\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// used in alien scene (option 1)
	}
	
	@Override
	public void twisted() {
		System.out.println("\"Smaller in number are we, but larger in mind.\"");
		super.setForce(getForce() + 1);
		// System.out.println(getForce());
		// used in alien scene (option 3)
	}

	@Override
	public void badEndPlayer() {
		Logic.printHeading("\nYou know the feeling when everything is lost,"
				+ "  when there is no more hope?\nIn a way, it's like that"
				+ " time when all the Jedi had died or disappeared,\nwhen"
				+ " only fear remained. Your expertise in the force wasn't"
				+ " enough to\novercome the obstacles.  Long live " + getName() + ".\n");
		
		
	}

	@Override
	public void okayEndPlayer() {
		Logic.printHeading("\n" + UserLogic.name + ", I admire your strength"
				+ " and your fierceness.\nI remember how I felt when all"
				+ " hope was lost,\nwhen every Jedi was crushed, scattered,"
				+ " and left to\nfend for themselves in the universe. There is\n"
				+ "still hope, there is another chance for redemption.\n");
		
		
	}

	@Override
	public void goodEndPlayer() {
		Logic.printHeading("\nGreat job " + UserLogic.name + "! Your elegency"
				+ " in choosing what is right\nrather than what is correct has"
				+ " lead you here.\nYou have found the \"Easter Egg\", in thus"
				+ " the dungeon\nhas set you free. Your knowledge of the Force\n"
				+ "is strong, farewell " + UserLogic.name + "...\n");
		
	}

}


