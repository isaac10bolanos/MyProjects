package www.skillstorm.general;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListChallenge {
	public static void main(String[] args) {
		
		
		List<String> ninthGrade = new LinkedList<String>(
				Arrays.asList(new String[] {"Ram", "Michael", "John", "Ron"}));
		List<String> tenthGrade = new LinkedList<String>(
				Arrays.asList(new String[] {"Harry", "Ferros", "Lita", "John"}));
		List<String> finalStudents = finalStudentList(ninthGrade, tenthGrade);
		System.out.println(finalStudents);
		
	}
	
	private static List<String> finalStudentList(List<String> a, List<String> b) {
		List<String> list = a;
		for(String student : b) {
			if(!a.contains(student)) {
				list.add(student);
			}
		}
		return list;
	}

}
