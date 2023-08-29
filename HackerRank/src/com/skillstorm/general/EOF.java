package com.skillstorm.general;

import java.util.Scanner;

public class EOF {
/*
 * In computing, End Of File (commonly abbreviated
 * EOF) is a condition in a computer operating system
 * where no more data can be read from a data source.
 */
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int start = 0;
		
		while(scan.hasNext()) {
			start++;
			String line = scan.nextLine();
			System.out.println(start + " " + line);
		}
		
		scan.close();
		
		
	}

}
