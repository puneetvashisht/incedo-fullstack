package com.incedo.oops;

public class TestInheritance {
	
	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle(100, 120);
//		System.out.println(v1);
//		v1.run();
		
		Vehicle c1 = new Car(270, 55, 5, true);
		
		Plane p1 = new Plane(1000, 44, 10000);
		
//		Car c2 =  (Car)c1;
//		System.out.println(c1);
//		c1.run();
		
		
//		Vehicle vehicles[] = new Vehicle[2];
		Vehicle vehicles[] = {v1, c1, p1};
		
//		for(int i=0;i<1;i++) {
//			System.out.println(vehicles[i]);
//		}
		
		for(Vehicle v : vehicles) {
			System.out.println(v);
			v.run();
			v.stop();
		}
		
//		int scores[] = {34,34,33,3,3,44,4};
		
//		int scores[] = new int[27];
	}

}
