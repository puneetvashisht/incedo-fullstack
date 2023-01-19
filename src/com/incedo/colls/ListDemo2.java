package com.incedo.colls;

import java.util.LinkedList;
import java.util.List;

class Fruit{
	String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + "]";
	}
	@Override
	 public boolean equals(Object obj) {
		Fruit f = (Fruit)obj;
	       return this.name.equals(f.name);
	 }
	
}

public class ListDemo2 {
	
	
public static void main(String[] args) {
	List<Fruit> fruits = new LinkedList<>();
	fruits.add(new Fruit("apple"));
	fruits.add(new Fruit("mango"));
	fruits.add(new Fruit("grape"));
	fruits.add(new Fruit("pineapple"));
	
	
	
	System.out.println(new Fruit("apple").equals(new Fruit("apple")));
	
	System.out.println(new Employee(1, "Ravi", 3433).equals(new Employee(1, "Ravi", 45454)));
	
	System.out.println(fruits.contains(new Fruit("mango")));

	
	
}

}
