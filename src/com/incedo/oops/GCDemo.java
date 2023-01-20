package com.incedo.oops;

public class GCDemo {
	
	public static void m1() {
		Integer x =34;
		m1();
	}
	
	public static void main(String[] args) {
		
		m1();
		
//		String str = "";
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0;i<100; i++) {
//			str += i;
			sb.append(i);
		}
		
		System.out.println(sb);
		
	}

}
