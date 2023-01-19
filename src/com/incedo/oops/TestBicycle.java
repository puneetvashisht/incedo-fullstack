package com.incedo.oops;

import java.util.ArrayList;

public class TestBicycle {

	public static void main(String[] args) {
		
//		Bicycle b = new Bicycle(3);
		
		Bicycle rb = new RoadBicycle(10);
//		rb.speedUp();
//		
//		System.out.println(rb);
		
		Bicycle mb = new MountainBicycle(10, 6);
//		mb.speedUp();
//		
//		System.out.println(mb);
		
		ArrayList<Bicycle> bicycles = new ArrayList<>();
		
		bicycles.add(rb);
		bicycles.add(mb);
		
		
		for(Bicycle b : bicycles) {
			b.speedUp();
			System.out.println(b);
			b.brakeDown();
			System.out.println(b);
		}
		
		
		
	}
}
