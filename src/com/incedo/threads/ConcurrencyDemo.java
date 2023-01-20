package com.incedo.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.incedo.colls.Employee;


class SalaryIncrementCallable implements Callable<Double>{
	
	Employee employee;
	
	public SalaryIncrementCallable(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public Double call() throws Exception {
		try {
			this.employee.incrementSalary();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.employee.salary;
	}
	
}

public class ConcurrencyDemo {

//	static ExecutorService service = Executors.newFixedThreadPool(2);
	
	static ExecutorService service = new ThreadPoolExecutor(2, 4,
            0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(2));

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Employee e1 = new Employee(11, "Ravi", 10000);
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
		
		List<Future> futures = new ArrayList<>();

		for (Employee e : employees) {
			SalaryIncrementCallable task = new SalaryIncrementCallable(e);
			Future<Double> future = service.submit(task);
			futures.add(future);
		}
		
		double totalOrganizationSalarySpend = 0;
		for(Future<Double> f: futures) {
			System.out.println(f.get());
			totalOrganizationSalarySpend+=f.get();
		}
		System.out.println(totalOrganizationSalarySpend);
		
		service.shutdown();

	}

}
