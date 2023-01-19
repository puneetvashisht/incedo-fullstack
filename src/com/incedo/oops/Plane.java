package com.incedo.oops;

public class Plane extends Vehicle{
	
	int maxAltitude;

	public Plane(int maxSpeed, double mileage, int maxAltitude) {
		super(maxSpeed, mileage);
		this.maxAltitude = maxAltitude;
	}

	@Override
	public String toString() {
		return "Plane [maxAltitude=" + maxAltitude + ", maxSpeed=" + maxSpeed + ", mileage=" + mileage + "]";
	}

	@Override
	public void run() {
		System.out.println("flying ...");
	}
	
	

}
