package www.skillstorm.general;

import java.util.ArrayList;
import java.util.List;

public class AssignAvailableList {
	
	public static void main(String[] args) {
		
		someMethod();
	}
	
	public static void someMethod() {
		List<String> availableList = new ArrayList<>();
		List<String> assignedList = new ArrayList<>();
		
		availableList.add("Marine");
		availableList.add("Army");
		availableList.add("AF");
		availableList.add("Navy");
		
		assignedList.add("Space Force");
		assignedList.add("Army National Guard");
		
		
		List<String> tempList = new ArrayList<>();
		for (String name : assignedList) {
			if (availableList.contains(name)) {
				tempList.add(name);	
			}
		}
		
		if (!tempList.isEmpty()) {
			System.out.println("User assigned " + tempList + " to the list.");
		}
		
		System.out.println("Current available list: " + availableList);
		System.out.println("Current assigned list: " + assignedList);
	}
	
	public static void addAssign() {
		List<String> tempAdd = new ArrayList<>();
		
	}

}
