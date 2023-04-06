package com.incedo.colls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo {

	public static void main(String[] args) {
		Employee e1 = new Employee(11, "Ravi", 3433);
		Employee e2 =new Employee(2, "Priya", 45454);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		
		System.out.println(employees);
		
		System.out.println(e1.companyName);
		System.out.println(Employee.companyName);
		
//		Collections.sort(employees);
		
		employees.stream()
		.sorted((o1, o2) -> (int)(o1.salary - o2.salary))
		.forEach((e)-> System.out.println(e));
		
//		System.out.println(employees);
		
////		Collections.sort(employees, new SalaryComparator());
//		Collections.sort(employees, (o1, o2) -> (int)(o1.salary - o2.salary) );
//		
//		System.out.println(employees);
//		
//		
//		Thread t = new Thread(()-> System.out.print("Run by thread: "));
//		t.start();
	}

}
