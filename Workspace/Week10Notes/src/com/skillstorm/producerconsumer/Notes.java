package com.skillstorm.producerconsumer;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Notes {
	
	public void testRefs(String str, StringBuilder sb) {
		str = str + sb.toString();
		sb.append(str);
		str = null;
		sb = null;
	}
	
	

	
	
	public static void main(String[] args) throws Exception {
		
		
		
		String s = "aaa";
		StringBuilder sb = new StringBuilder("bbb");
		new Notes().testRefs(s, sb);
		System.out.println("s=" + s + " sb="+sb);
		
		
	}
	
	
	
	public static void stringFormat() {
		Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            while(sc.hasNext()){
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s%03d%n", s1, x);    
            }
            
            //Complete this line
        }
        System.out.println("================================");
        sc.close();
	}

}
