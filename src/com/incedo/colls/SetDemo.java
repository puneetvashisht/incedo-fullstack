package com.incedo.colls;

import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		
		// Hashset - unordered
		// LinkedHashSet - insertion order
		// TreeSet - sorted by Comparable or explicit comparator
		
		
		
		Set<Employee> employees = new TreeSet<>(new SalaryComparator());
		
		Employee e1 = new Employee(11, "Ravi", 3433);
		Employee e4 = new Employee(11, "Ravi", 3433);
		Employee e2 =new Employee(2, "Priya", 45454);
		Employee e3 =new Employee(12, "Rahul", 25454);
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		System.out.println(employees);
		
		System.out.println(employees.contains(new Employee(11, "Ravi", 3433)));

	}

}
