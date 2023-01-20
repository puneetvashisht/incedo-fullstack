package com.incedo.threads;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.incedo.colls.Employee;

class MyRunnable implements Runnable{
	
	Employee employee;

	public MyRunnable(Employee employee) {
		super();
		this.employee = employee;
	}



	@Override
	public void run() {
		System.out.println("Current thread" + Thread.currentThread().getName());
		// increment employe salary
		try {
			employee.incrementSalary();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class SalaryIncrementDemo {

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
		
		
		List<Thread> threads = new ArrayList<>();
		
//		System.out.println(System.currentTimeMillis());
		System.out.println("Start time" + LocalDateTime.now());
		
		for(Employee e : employees) {
			MyRunnable runnable = new MyRunnable(e);
			Thread t = new Thread(runnable);
			t.start();
			threads.add(t);
		}
		
		
		for(Thread t: threads) {
			try {
				t.join();
			} catch (InterruptedException e5) {
				// TODO Auto-generated catch block
				e5.printStackTrace();
			}
		}
		
		System.out.println("End time" + LocalDateTime.now());
		

	}

}
