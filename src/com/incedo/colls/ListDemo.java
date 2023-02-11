package com.incedo.colls;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	
	
public static void main(String[] args) {
	List<String> list = new ArrayList<>();
	list.add("34");
	list.add("45");
//	list.add(34);
	
//	int a = new Integer(34);
	
	for(String s : list) {
		System.out.println(s.charAt(0));
	}
	
	System.out.println(list);
	
	for(Object e: list) {
		System.out.println(e);
		
		if(e instanceof String) {
			String s = (String)e;
			System.out.println(s.charAt(0));
		}
		
		
	}
	
}

}
