package com.incedo.oops;

public class Car extends Vehicle{
	
	int seatingCapacity;
	boolean autoGear;
	
	public Car() {
		
	}
	public Car(int maxSpeed, double mileage, int seatingCapacity, boolean autoGear) {
		super(maxSpeed, mileage);
		this.seatingCapacity = seatingCapacity;
		this.autoGear = autoGear;
	}
	
	@Override
	public void run() {
		System.out.println("car running...");
	}
	
	@Override
	public String toString() {
		return "Car [seatingCapacity=" + seatingCapacity + ", autoGear=" + autoGear + ", maxSpeed=" + maxSpeed
				+ ", mileage=" + mileage + "]";
	}
	
	
	

}
