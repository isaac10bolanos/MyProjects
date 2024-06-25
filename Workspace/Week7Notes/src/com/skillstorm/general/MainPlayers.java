package com.skillstorm.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.skillstorm.general.Players.Position;

public class MainPlayers {
	
	public static void main(String[] args) {
		
		Map<String, ArrayList<Players>> playerInventory = new HashMap<>();
		playerInventory.put("FC Barcelona", new ArrayList<Players>());
		playerInventory.put("Real Madrid", new ArrayList<Players>());
		
		ArrayList<Players> fcBarcelona = playerInventory.get("FC Barcelona");
		fcBarcelona.add(new Players("Messi", 19, Position.FORWARD));
		fcBarcelona.add(new Players("Fabregas", 15, Position.MIDFIELD));
		fcBarcelona.add(new Players("Alves", 20, Position.DEFENSE));
		
		ArrayList<Players> realMadrid = playerInventory.get("Real Madrid");
		realMadrid.add(new Players("Ronaldo", 10, Position.FORWARD));
		realMadrid.add(new Players("Modric", 23, Position.MIDFIELD));
		realMadrid.add(new Players("Ramos", 5, Position.DEFENSE));
		
//		System.out.println(fcBarcelona);
//		System.out.println(realMadrid);
//		System.out.println(playerInventory);
		
		for(Map.Entry<String, ArrayList<Players>> entry : playerInventory.entrySet()) {
			
			for(Players player : entry.getValue()) {
				String name = player.getName();
				
				switch(name.toLowerCase()) {
					case "messi":
						player.setName("Lionel "+ name);
						player.setNumber(10);
						break;
					case "fabregas":	
						player.setName("Cesc " + name);
						player.setNumber(4);
						break;
					case "alves":
						player.setName("Dani " + name);
						player.setNumber(2);
						break;
					case "ronaldo":
						player.setName("Cristiano " + name);
						player.setNumber(9);
						break;
					case "modric":
						player.setName("Luca " + name);
						player.setNumber(10);
						break;
					case "ramos":
						player.setName("Sergio " + name);
						player.setNumber(4);
						break;
				}
			}
		}
		
		System.out.println(fcBarcelona);
		System.out.println(realMadrid);
		//System.out.println(playerInventory);
		
	}

}
