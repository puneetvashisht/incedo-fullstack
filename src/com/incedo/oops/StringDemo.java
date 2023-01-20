package com.incedo.oops;

public class StringDemo {

	public static void main(String[] args) {
		String str1 = "Incedo";
		String str2 = new String("Incedo");
		
		if(str1 == str2) {
			System.out.println("Same references..");
		}
		
		String result = str1.concat(str2);
		
		System.out.println(result);
 
	}

}
