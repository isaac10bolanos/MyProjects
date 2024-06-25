package www.skillstorm.beans;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;


public class Notes {
	
	private String id = "hello";
	
	void print() {
		System.out.println(id);
	}
	
	
	public static void main(String[] args) {
		



		

		//booleanLogic();
		//array2d();
		//stringBuilder();
		//arrays();
		//dateNotes();
		//random();
		
	}
	
	public static void booleanLogic() {
		System.out.println(Boolean.parseBoolean("true"));
		// this is similar to Integer.parseInt displays a primitive
		
		System.out.println(Boolean.valueOf(true));
		
		System.out.println(Boolean.valueOf("trUE"));
		// valueOf ignores case
		// does not have trim() so " trUE " will evaluate to false
		
		System.out.println(Boolean.TRUE);
		
	}

	public static void array2d() {
		String[][] matrix = new String[2][2];
		matrix[0][0] = "petrol";
		matrix[1][0] = "diesel";
		matrix[0][1] = "manual";
		matrix[1][1] = "auto";
		
		for(String[] row: matrix) {
			for(String column: row) {
				System.out.print(column + ":");
			}
		}
		
		System.out.println();
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(matrix[i][j] + ":");
			}
		}
		
		System.out.println();
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(matrix[j][i] + ":");
			}
		}
		
		// more examples
		String ia[][] = { { "1", "2" },  {null, null} };
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.println(ia[i][j]);
			}
		}
	}
	
	public static void stringBuilder() {
		StringBuilder sb = new StringBuilder("asdf");
		String str1 = sb.toString();
		String str2 = str1;
		System.out.println(str1 == str2);
		System.out.println(str1);
		System.out.println(sb);
		
		
		// more examples
		System.out.println(" hello world".trim());
		System.out.println("hello".concat(" world"));
		System.out.println(new StringBuilder("world").insert(0, "hello ").toString());
	}
	
	public static void arrays() {
		int [][] array = { {0}, {0, 1, 2}, {0, 1, 2, 3}, {0, 1, 2, 3, 4}};
		System.out.println(array[3][2]);
		
		for(int[] row: array) {
			System.out.print("[ ");
			for(int value: row) {
				System.out.print(value + " ");
			}
			System.out.println("]");
		}
	}
	
	public static void random() {
		//System.out.println(1 + Math.random() * 9);
		System.out.println(1 + Math.round(Math.random()*9));
	}
	
	public static void dateNotes() {
		
		System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
		// both print out the next TUESDAY in 2023-05-02 format
		System.out.println(TemporalAdjusters.next(DayOfWeek.TUESDAY).adjustInto(LocalDate.now()));
		
		
		
		
		LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);
		
		ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Duration.ofDays(1));
		System.out.println(date);
		
		date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Period.ofDays(1));
		System.out.println(date);
	}

}
