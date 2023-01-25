package com.cts;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cts.entities.Address;
import com.cts.entities.Employee;
import com.cts.repos.EmployeeRepo;

public class TestEmployeeWithAddressRepo {

	private EmployeeRepo repo = new EmployeeRepo();

	@BeforeClass
	public static void setUp() {
		// repo.
	}

	// @Test
	public void addEmployee() {

		Address address = new Address("Gk", "Delhi");
		Employee emp1 = new Employee();
		emp1.setName("Sandeep");
		// emp1.setAddress(address);
		repo.addEmployee(emp1);
	}

//	@Test
	public void addEmployeeWithAddresses() {

		Address address = new Address("Gk", "Delhi");
		Address officeAddress = new Address("DLF", "Gurugram");
		Set<Address> addresses = new HashSet<>();
		addresses.add(address); addresses.add(officeAddress);
		Employee emp1 = new Employee();
		
		emp1.setName("Lini");
		emp1.setAddresses(addresses);
		// emp1.setAddress(address);
		repo.addEmployee(emp1);
		
		
		emp1.setName("ABCD");
	}
	

	@Test
	public void findEmployee() {
		Employee employee = repo.findEmployee(7);
		System.out.println(employee);
		
		employee.setName("ZZZZ");
		
		System.out.println(employee.getAddresses());
//		 System.out.println(employee.getAddress());
	}

}
