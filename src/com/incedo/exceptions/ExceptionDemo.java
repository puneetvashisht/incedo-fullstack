package com.incedo.exceptions;

public class ExceptionDemo {

	public static void m2(int x) throws InvalidInputException   {
		if(x==0) {
			throw new InvalidInputException("Invalid input x..");
		}
		int y = 34 / x;
		
		

	}

	public static void m1() {

			try {
				m2(1);
			}
			catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			finally {
				System.out.println("Always works!");
			}
		System.out.println("m1 method");

	}

	public static void main(String[] args) {
		m1();
		System.out.println("Allz well");

	}

}
