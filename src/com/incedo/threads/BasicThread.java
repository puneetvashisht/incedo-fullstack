package com.incedo.threads;

public class BasicThread {
	
	public static void main(String[] args) {
		
		for(int i=0; i<10;i++) {
			Thread t = new Thread(()->  {
				System.out.println("Run by thread: " + Thread.currentThread().getName());
			});
			t.start();
		}
		
		System.out.println("Main Run by thread: " + Thread.currentThread().getName());
	}

}
