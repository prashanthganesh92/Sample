package org.packag.dataProviders;

import java.util.Iterator;

public class stringReverse {
	public static void main(String[] args) {
		
	
	String a = "Java@gmail.com";
	String b = "";
	int count = 0;
	
	for (int i = a.length()-1; i>=0; i--) {
		
		char c = a.charAt(i);
		
		b= b+ c;
		count++;
		
		
	}
		System.out.println(b);
		
		System.out.println(count);
	}
}
	
