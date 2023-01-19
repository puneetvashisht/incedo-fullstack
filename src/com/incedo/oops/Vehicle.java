package com.incedo.oops;

public class Vehicle extends Object{
	
	int maxSpeed;
	double mileage;

	public Vehicle() {
		
	}
	
	public Vehicle(int maxSpeed, double mileage) {
		super();
		this.maxSpeed = maxSpeed;
		this.mileage = mileage;
	}

	public void stop() {
		System.out.println("Stop just now!");
	}

	public void run() {
		System.out.println("running...");
	}



	@Override
	public String toString() {
		return "Vehicle [maxSpeed=" + maxSpeed + ", mileage=" + mileage + "]";
	}
	
	

}
