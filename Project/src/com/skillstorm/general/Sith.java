package com.skillstorm.general;

public class Sith extends Player{
	
	public Sith() {}

	public Sith(String name, String type,
			int force, String weapon) {
		super(name, type, force, weapon);
	}
	
	@Override
	public void remember() {
		System.out.println("It was the dark side of the force that led you to open it.\n");
		System.out.println("\"You can't stop the change, any more than you\n"
				+ "can stop the suns from setting.\"");
		super.setForce(getForce() + 1);
		// System.out.println(getForce());
		// used in chest scene (option 1)
		
	}
	
	@Override
	public void simple() {
		System.out.println("\"I'm just a simple man trying to make my way in the universe.\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// boba fett quote
		// used in chest scene (option 2)
	}
	
	@Override
	public void oneWithForce() {
		System.out.println("Be careful not to choke on your aspirations, " + UserLogic.name);
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in chest scene (option 3)
		
	}
	
	@Override
	public void feeling() {
		System.out.println("The Sith are like this, with no regard for the opposition.\n");
		System.out.println("\"I can bring you in warm, or I can bring you in cold.\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// mandolorian
		// used in rancor scene (option 1)
		
	}
	
	@Override
	public void clever() {
		System.out.println(UserLogic.name + " you're asking me to be rational. I know that is something I cannot do.");	
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in rancor scene (option 2)
		
	}
	
	@Override
	public void quote() {
		System.out.println("Despite " + getName() + "'s cleverness and deception, you took a toll from the rancor\n"
				+ "because of your inadequacy.\n");
		System.out.println("\"I find your lack of faith disturbing.\"");
		super.setForce(getForce() - 1);
		// System.out.println(getForce());
		// used in rancor scene (option 3)
		
	}
	
	@Override
	public void force() {
		System.out.println("The woman reminds you of your mother, but you have no compassion for anyone else.\n");
		System.out.println("\"Life seems so much simpler when you're fixing things.\"");
		super.setForce(getForce() - 1);
		// System.out.println(getForce());
		// used in lady scene (option 3)
		
	}
	
	@Override
	public void pass() {
		System.out.println("She could of been your mother, you could of saved her...\n");
		System.out.println("\"Mom, you said that the biggest problem in this universe is nobody helps each other.\"");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in lady scene (option 2)
		
	}
	
	@Override
	public void speak() {
		System.out.println("You want to help her because she reminds you of someone very dear.\n");
		System.out.println("\"I won't lose you the way I lost my mother.\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		 // anakin talking to padme
		// used in lady scene (option 1)
		
	}
	
	@Override
	public void strong() {
		System.out.println("I hope so for your sake, " + UserLogic.name + ". The Emperor"
				+	" is not as forgiving as I am.");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in door scene (option 3)
		
	}
	
	@Override
	public void right() {
		System.out.println("\"You were right, " + UserLogic.name + ". You were right...\"");
		super.setForce(getForce() + 1);
		// System.out.println(getForce());
		// used in door scene (option 1)
		
	}
	
	@Override
	public void twist() {
		System.out.println(UserLogic.name + ", we would be honored if you joined us.");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// used in door scene (option 2)
		
	}
	
	@Override
	public void twisted() {
		System.out.println("It's time to unleash your full anger on those aliens. What a remarkable scene!\n");
		System.out.println("\"You don't know the power of the Dark Side!\"");
		super.setForce(getForce() + 1);
		// System.out.println(getForce());
		// used in alien scene (option 3)
		
	}
	
	@Override
	public void size() {
		System.out.println("Those poor aliens were subjected to your full power.\n");
		System.out.println("\"If you only knew the power of the dark side.\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// used in alien scene (option 1)
	}
	
	@Override
	public void small() {
		System.out.println("While fear is a part of the dark side, " + getName() + " wouldn't cower in fear.\n");
		System.out.println("\"You underestimate my power!\"");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in alien scene (option 2)
		
	}
	
	public void iDone() {
		System.out.println("\"What have I done?\"");
	} // still have not used

	@Override
	public void badEndPlayer() {
		Logic.printHeading("\nWhile you tried to follow the right path, the dark side had you.\n"
				+ "Nothing can be undone of all the suffering you have caused.\n"
				+ "There was a time when you were good, but no longer are you.\n"
				+ "Fear can no longer be caused by you. Consumed by the dark side\n"
				+ "are you, consumed by the dungeon are you too.\n");
		
	}

	@Override
	public void okayEndPlayer() {
		Logic.printHeading("\n" + UserLogic.name + " you were so close yet so far. You are torn between light\n"
				+ "and darkness, and that has led you here. In your awakening,\n"
				+ "you were confined to the dungeon. But you identify with being\n"
				+ "half broken, it's what makes you unique. There is another chance,\n"
				+ "but it will be determined by a continue statement inside the dungeon.\n");
		
	}

	@Override
	public void goodEndPlayer() {
		Logic.printHeading("\nCan you feel that? Your treacherous ways and arrogance\n"
				+ "led you to the \"Easter Egg\". The force is within you,\n"
				+ "but in a bad way. The universe has been warned that you\n"
				+ "have escaped. Well, good luck out there...oh wait, you're\n"
				+ "not going to need it because you are an evil Sith...\n");
		
	}


	
}


