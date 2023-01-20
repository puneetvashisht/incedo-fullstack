package com.incedo.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.incedo.colls.Employee;

public class ConcurrencyDemo {

	static ExecutorService service = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {

		Employee e1 = new Employee(11, "Ravi", 3433);
		Employee e4 = new Employee(11, "Ravi S", 3433);
		Employee e2 = new Employee(2, "Priya", 45454);
		Employee e3 = new Employee(12, "Rahul", 25454);
		Employee e5 = new Employee(2, "Priya", 45454);
		Employee e6 = new Employee(12, "Rahul", 25454);

		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
		employees.add(e6);

		for (Employee e : employees) {
			SalaryIncrementTask task = new SalaryIncrementTask(e);
			service.submit(task);
		}
		
		service.shutdown();

	}

}
