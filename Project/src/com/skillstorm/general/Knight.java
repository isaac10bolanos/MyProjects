package com.skillstorm.general;

public class Knight extends Player{
	
	public Knight() {}
	
	public Knight(String name, String type,
			int force, String weapon) {
		super(name, type, force, weapon);
	}
	
	@Override
	public void remember() {
		System.out.println("In your Jedi knight approach, you did not use your skills to sense something was abyss.\n");
		System.out.println("\"Remember...the Force will be with you, always.\"");
		super.setForce(getForce() - 1);
		// System.out.println(getForce());
		// used in chest scene (option 1)
	}
	
	@Override
	public void simple() {
		
		System.out.println(UserLogic.name + " why do I get the feeling you're going to be the death of me?");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in chest scene (option 2)
		
	}
	
	@Override
	public void oneWithForce() {
		System.out.println("It was an excellent use of your force knowledge.\n");
		System.out.println("\"These aren't the DROIDS you're looking for.\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// used in chest scene (option 3)
		
		
	}
	
	@Override
	public void feeling() {
		System.out.println("Rather than taking the time to wait, you attacked so reluctantly.\n");
		System.out.println(UserLogic.name + ", my allegiance is to the Republic, to democracy!");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in rancor scene (option 1)
	}
	
	@Override
	public void clever() {
		System.out.println(UserLogic.name + " is quite clever, you know...for a human being.");
		super.setForce(getForce() + 1);
		// System.out.println(getForce());
		// C-3P0 quote
		// used in rancor scene (option 2)
	} 
	
	
	@Override
	public void quote() {
		System.out.println(getName() + " waited for the rancor to stumble and then planned an attack.\n");
		System.out.println("\"Hello There!\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// used in rancor scene (option 3)
		
	}
	
	@Override
	public void pass() {
		System.out.println("Be mindful of your thoughts, " + UserLogic.name + ", they betray you.");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// obi-wan said to anakin (Attack of the Clones)
		// used in lady scene (option 2)
	}
	
	@Override
	public void force() {
		System.out.println("It is your duty to help when given the chance.\n");
		System.out.println("\"In my experience, there's no such thing as luck.\"");
		super.setForce(getForce() + 1);
		// System.out.println(getForce());
		// used in lady scene (option 3)
	}
	
	@Override
	public void speak() {
		System.out.println("You are an outstanding Jedi guardian of the unprotected.\n");
		System.out.println("\"Help me, " + getName() + ". You're my only hope.\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// LEIA quote
		// used in lady scene (option 1)
	}
	
	@Override
	public void strong() {
		System.out.println("The two others would be off limits to me as well.\n");
		System.out.println("\"This is the way.\""); // mandolorian
		// used in door scene (option 3)
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		
	}
	
	@Override
	public void right() {
		System.out.println(UserLogic.name + " I've got a bad feeling about this.");
		super.setForce(getForce() - 1);
		// System.out.println(getForce());
		// used in door scene (option 1)
	}
	
	@Override
	public void twist() {
		System.out.println("\"You have allowed this dark lord to twist your mind, until now,\n"
			+	"until now, you've become the very thing you swore to destroy.\"");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in door scene (option 2)
	}
	
	@Override
	public void size() {
		System.out.println("As you learn the ways of the Jedi, the force is strong in your hands.\n");
		System.out.println("\"How wude!\"");
		super.setForce(getForce() + 2);
		// System.out.println(getForce());
		// used in alien scene (option 1)
	}
	
	@Override
	public void twisted() {
		System.out.println("Jedi weapons can only be handled by skilled Jedi knights.\n");
		System.out.println("\"So Uncivilized.\"");
		super.setForce(getForce() + 1);
		// System.out.println(getForce());
		// used in alien scene (option 3)
		
	}
	
	@Override
	public void small() {
		System.out.println("It is here that fear leads to the dark side.\n");
		System.out.println("\"There's always a bigger fish.\"");
		super.setForce(getForce() - 2);
		// System.out.println(getForce());
		// used in alien scene (option 2)
	}

	@Override
	public void badEndPlayer() {
		Logic.printHeading("\nLet's imagine you are fighting your best friend on Mustafar.\n"
				+ "In the story, he told you how he turned to the dark side and killed\n"
				+ "younglings. That is the pain and suffering you are going through.\n"
				+ "You have failed " + getName() +".\n");
		
	}

	@Override
	public void okayEndPlayer() {
		Logic.printHeading("\n" + UserLogic.name + " there is no doubt that you have fought valiantly\n"
				+ "and tenaciously. But in crummy terms you have dwindled.\n"
				+ "Even though you failed, there is still hope. There is still\n"
				+ "one more \"if - else\" for reclamation.\n");
		
	}

	@Override
	public void goodEndPlayer() {
		Logic.printHeading("\n" + UserLogic.name + " despite not being a Jedi master, you have demonstrated\n"
				+ "that you are capable of becoming one. It was your sense and\n"
				+ "understanding of the Force that led you to the \"Easter Egg\". You\n"
				+ "have escaped the dungeon, and are now a free spirit."
				+ " So long " + UserLogic.name + "...\n");
		
	}

}

