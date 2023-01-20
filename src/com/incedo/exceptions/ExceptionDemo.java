package com.incedo.exceptions;

public class ExceptionDemo {
	
	public static void m2(int x) throws InvalidInputException{
		if(x==0) {
			throw new InvalidInputException("Invalid input x..");
			
		}
		int y = 34/x;
		
		
	}
	
	public static void m1() {
		try {
			m2(0);
		} 
		
		catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("Always runs!");
		}
		
		System.out.println("m1 method");
		
	}

	public static void main(String[] args) {
		m1();
		
//		try {
//			m1();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("Allz well");

	}

}
