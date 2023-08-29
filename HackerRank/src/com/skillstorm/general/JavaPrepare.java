package com.skillstorm.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaPrepare {
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		
		for (int i = 0; i < tc; i++) {
			
			try {
			
			long x = scan.nextLong();
			System.out.println(x + " can be fitted in:");
			
			if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
				System.out.println("* short");
			}
			
			if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
				System.out.println("* int");
			}
			
			if (x >= Long.MIN_VALUE && x <= Long.MAX_VALUE) {
				System.out.println("* long");
			}
			
			} catch (Exception ex) {
				System.out.println(scan.next() + " can't be fitted anywhere.");
			}
		}
		
		scan.close();
//		System.out.print("Enter a number: ");
//		int n = scan.nextInt();
		//readInput(scan);
		//printFormat(scan);
		//simpleMultiply();
		//queryMath(scan);
		//pow(scan);
//		threeFive(n);
	}
	
	public static void threeFive(int n) {
		
		// hacker rank question
		// if number is divisible by 3, 5, or both
		System.out.println();
		for (int i = 1; i <= n; i++) {
			if (i % 5 == 0 && i % 3 == 0) {
				System.out.println(i + " is both");
			} else if (i % 3 == 0) {
				System.out.println(i + " -- is divisible by 3");
			} else if (i % 5 == 0) {
				System.out.println(i + " -- is divisible by 5");
			} else {
				System.out.println(i);
			}
		}
		
	}
	
	public static void pow(Scanner scan) {
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int n = scan.nextInt();
			
			int currentValue = a;
			for (int j = 0; j < n; j++) {
				currentValue += (int)(Math.pow(2, j) * b);
				System.out.print(currentValue + " ");
			}
			System.out.println();
		}
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
