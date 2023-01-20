package com.incedo.threads;

import java.util.ArrayList;
import java.util.List;

import com.incedo.colls.Employee;


class SalaryIncrementTask implements Runnable{
	
	Employee employee;
	
	public SalaryIncrementTask(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public void run() {
		try {
			this.employee.incrementSalary();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class EmployeeIncrementDemo {

	public static void main(String[] args) {
		Employee e1 = new Employee(11, "Ravi", 3433);
		Employee e4 = new Employee(11, "Ravi S", 3433);
		Employee e2 =new Employee(2, "Priya", 45454);
		Employee e3 =new Employee(12, "Rahul", 25454);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		
		System.out.println(System.currentTimeMillis());
		
		List<Thread> threads = new ArrayList<>();
		
		for(Employee e : employees) {
			
			
			SalaryIncrementTask task = new SalaryIncrementTask(e);
			Thread t = new Thread(task);
			t.start();
			
			threads.add(t);
			
			
//			try {
//				e.incrementSalary();
//			} catch (InterruptedException e5) {
//				// TODO Auto-generated catch block
//				e5.printStackTrace();
//			}
		}
		
		// waiting logic separated..
		for(Thread t: threads) {
			try {
				t.join();
			} catch (InterruptedException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}
		}
		
		System.out.println(System.currentTimeMillis());

	}

}
