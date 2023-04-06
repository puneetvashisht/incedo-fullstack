package com.incedo.colls;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	
	public static void main(String[] args) {
		Employee e1 = new Employee(11, "Ravi", 3433);
		Employee e4 = new Employee(11, "Ravi S", 3433);
		Employee e2 =new Employee(2, "Priya", 45454);
		Employee e3 =new Employee(12, "Rahul", 25454);
		
		Map<Integer, Employee> employeeMap = new HashMap<>();
		employeeMap.put(11, e1);
		employeeMap.put(2, e2);
		employeeMap.put(12, e3);
//		employeeMap.put(null, e4);
		
		System.out.println(employeeMap.get(2));
		
		
		
		System.out.println(employeeMap.keySet());
		
		Set<Integer> keys = employeeMap.keySet();
		
		for(Integer key: keys) {
			System.out.println(employeeMap.get(key));
		}
		
	}

}
