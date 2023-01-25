package com.cts;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cts.entities.Employee;
import com.cts.repos.EmployeeRepo;

public class TestEmployeeRepo {
	
	private EmployeeRepo repo = new EmployeeRepo();

	@BeforeClass
	public static void setUp(){
//		repo.
	}
	
//	@Test
	public void addEmployee(){
		Employee emp1 = new Employee();
		emp1.setName("Priya");	
		repo.addEmployee(emp1);
	}
	
	@Test
	public void findEmployee(){
		Employee employee = repo.findEmployee(1);
		System.out.println(employee);
	}

}
