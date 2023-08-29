package com.skillstorm.general;

import java.util.Scanner;

public class StaticInitializerBlock {
	
	
	  static int breadth;
	    static int height;
	    static boolean isValid = true;

	    // Static initialization block
	    static {
	        Scanner scanner = new Scanner(System.in);
	        breadth = scanner.nextInt();
	        height = scanner.nextInt();
	        scanner.close();

	        if (breadth <= 0 || height <= 0) {
	            isValid = false;
	        }
	    }

	    public static void main(String[] args) {
	        try {
	            if (!isValid) {
	                throw new java.lang.Exception("java.lang.Exception: Breadth and height must be positive");
	            }

	            int area = breadth * height;
	            System.out.println(area);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}







