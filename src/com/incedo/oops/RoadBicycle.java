package com.incedo.oops;

public class RoadBicycle extends Bicycle implements Motor{

	
	
	public RoadBicycle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoadBicycle(int speed) {
		super(speed);
	}


	@Override
	public String toString() {
		return "RoadBicycle [speed=" + speed + "]";
	}

	@Override
	public void speedUp() {
		this.speed+=1;
		
	}

	

	@Override
	public void start() {
		System.out.println("Starting motor...");
		
	}
	
	
	
}
