package com.cts;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cts.inherit.entities.ContractEmployee;
import com.cts.inherit.entities.Employee;
import com.cts.inherit.entities.RegularEmployee;
import com.cts.inherit.repos.EmployeeRepo;



public class TestEmployeeRepoInheritance {
	
	private EmployeeRepo repo = new EmployeeRepo();

	@BeforeClass
	public static void setUp(){
//		repo.
	}
	
//	@Test
	public void addRegularEmployee(){
		RegularEmployee emp1 = new RegularEmployee("John", 34343.33, 3);
		repo.addEmployee(emp1);
	}
	
	@Test
	public void addContractEmployee(){
		ContractEmployee emp1 = new ContractEmployee("Ravi", 3434.34, 12);
		repo.addEmployee(emp1);
	}
//	@Test
	public void addEmployee(){
		Employee emp1 = new Employee("Priya");
		repo.addEmployee(emp1);
	}
	
//	@Test
	public void findEmployee(){
		Employee employee = repo.findEmployee(1);
		System.out.println(employee);
	}

}
