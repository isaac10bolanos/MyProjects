package com.skillstorm.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaPrepare {
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		//readInput(scan);
		//printFormat(scan);
		//simpleMultiply();
		queryMath(scan);
	}
	
	public static void queryMath(Scanner scan) {
		int q = scan.nextInt();
		for(int i = 0; i < q; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int n = scan.nextInt();
			
		}
		
	}
	
	public static void simpleMultiply(){
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		System.out.println("Simple Multiplication\n");
		System.out.print("Enter a number: ");
		try {
			n = Integer.parseInt(bf.readLine().trim());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// will only multiply to 10
		for(int i = 1; i <= 10; i++) {
			int result = n * i;
			System.out.println(n + " x " + i + " = " + result);
		}
	}
	
	public static void printFormat(Scanner scan) {
		System.out.println("=====================");	
		for(int i = 0; i < 3; i++) {
			while(scan.hasNext()) {
				String s1 = scan.next();
				int in = scan.nextInt();
				// %-15s adds whitespace from String to integer
				// %03d adds 0 if less than 3 ints ex: (1) -> (001)
				System.out.printf("%-15s%03d%n", s1, in);
				break;
			}
		}
		System.out.println("=====================");
	}
	
	public static void readInput(Scanner scan) {
		System.out.print("Enter int: ");
		int i = scan.nextInt();
		System.out.print("Enter double: ");
		double d = scan.nextDouble();
		scan.nextLine();
		System.out.print("Enter String: ");
		String message = scan.nextLine();
		scan.close();
		
		System.out.println("\nString: " + message);
		System.out.println("Double: " + d);
		System.out.println("Int: " + i);
		
		// if user inputs
		// int
		// double
		// String
		// it will still print out lines 20-22 in order
	}

}
