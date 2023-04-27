package com.skillstorm.beans;

import java.util.Scanner;

public class Login {
	Scanner sc;
	String username;
	String password;
	
	public Login(Scanner sc) {
		this.sc = sc;
	}
	
	public void makeUsername() {
		System.out.println("Enter Username:");
		username = sc.nextLine();
		
		System.out.println("Enter Password:");
		password = sc.nextLine();
	}
	
	
	

}
