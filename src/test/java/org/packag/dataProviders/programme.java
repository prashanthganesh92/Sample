package org.packag.dataProviders;

public class programme {
	public static void main(String[] args) {
		

	int input =123456;
	int reverse =0;
	int count =0;
	
	while(input>0) {
		int a = input/10;
		int b = input%10;
		reverse = b + (reverse*10);
		input = a;
		count++;
	}
	System.out.println(reverse);
	
	if (input==reverse) {
		System.out.println("polidrome no.");
	}
	else {
		System.out.println("not polindrome");
	}
	
	System.out.println("The number of digits " +count);
	}
}


