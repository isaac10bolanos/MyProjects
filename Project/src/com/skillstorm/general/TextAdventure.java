package com.skillstorm.general;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TextAdventure {
	
	public static void main(String[] args) {
		Random rand = new Random(); // to use random
		Scanner in = new Scanner(System.in); // to use in Scanner throughout game
		
		
		SceneLogic scenerios = new SceneLogic(); // create instance for scenes
		UserLogic player = new UserLogic(); // create instance for player use
		Player user = player.welcome(in); // create player class  
		
		// wrapper class for int 
		ArrayList<Integer>scenes = new ArrayList<Integer>();
		// new array list that can add more on the list
		
		// length of my ArrayList(5)
		while(scenes.size() < 5) {
			int random = rand.nextInt(5); // randomize 5 initial scenes
			if(!scenes.contains(random)) { // if it doesn't contain it, add it
				scenes.add(random);
			}
		}
		
		// adding the final scene
		scenes.add(5);
		
		// looping through first 5 scenes randomly, last 1 is final scene
		for(int num: scenes) {
			if(num == 0) {
				scenerios.door(user, in);
				
			} else if(num == 1) {
				scenerios.aliens(user, in);
				
			} else if (num == 2) {
				scenerios.lady(user, in);
				
			} else if (num == 3) {
				scenerios.rancor(user, in);
				
			} else if (num == 4) {
				scenerios.chest(user, in);
				
			} else if (num == 5) {
				
				if(user.getForce() >= 13) {
					scenerios.goodEnd(user, in);
					
				} else if (user.getForce() >= 7 && user.getForce() <= 12){
					scenerios.okayEnd(user, in);
					
				} else {
					scenerios.badEnd(user, in);
				}
				
				in.close();
				// closes the scanner
			}		
		}
	}	
}	