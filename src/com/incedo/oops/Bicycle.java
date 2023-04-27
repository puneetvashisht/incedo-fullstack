package com.incedo.oops;

public abstract class Bicycle implements IBicycle{
	
	protected int speed;
	
	
	public abstract void test();
	
	
	public Bicycle() {
		super();
	}

	public Bicycle(int speed) {
		super();
		this.speed = speed;
	}
	
	public void brakeDown() {
		this.speed--;
	}

//	public void speedUp() {
//		
//	}
//	
//	public void brakeDown() {
//		
//	}

	@Override
	public String toString() {
		return "Bicycle [speed=" + speed + "]";
	}
	
	
	
}
