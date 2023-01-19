package com.incedo.colls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamsDemo {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(11, "Ravi", 3493);
		Employee e4 = new Employee(11, "Ravi S", 3453);
		Employee e2 =new Employee(2, "Priya", 45454);
		Employee e3 =new Employee(12, "Rahul", 25454);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		
		
		Optional<Employee> employeeWithMinSalary =  employees.stream()
		//intermediate function
		.filter(e-> e.name.startsWith("R"))
		.min((o1,o2)-> (int)(o1.salary - o2.salary));
		//terminal functions
//		.forEach(e-> System.out.println(e));
		if(employeeWithMinSalary.isPresent()) {
			System.out.println(employeeWithMinSalary.get());
		}
		
		
		OptionalDouble maxSalary = employees.stream()
		.filter(e-> e.name.startsWith("R"))
		.mapToDouble((e)-> e.salary)
		.max();
		
		if(maxSalary.isPresent()) {
			System.out.println(maxSalary.getAsDouble());
		}
//		.forEach((d)-> System.out.println(d));
		
		
		
		

	}

}
