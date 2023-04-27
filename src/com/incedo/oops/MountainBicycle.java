package com.incedo.oops;

public class MountainBicycle extends Bicycle{
	
	int gears;
	
	public MountainBicycle() {
		super();
	}

	public MountainBicycle(int speed, int gears) {
//		super(speed);
		this();
		this.gears = gears;
	}

	public void speedUp() {
		this.speed+=2;
		
	}
	
	

	@Override
	public String toString() {
		return "MountainBicycle [gears=" + gears + ", speed=" + speed + "]";
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
