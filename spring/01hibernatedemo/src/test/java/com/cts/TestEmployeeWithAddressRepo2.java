package com.cts;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cts.entities.Address;
import com.cts.entities.Employee;
import com.cts.repos.EmployeeRepo;

public class TestEmployeeWithAddressRepo2 {

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
		Employee emp1 = new Employee();
		emp1.setName("Romit");
		

		Address address = new Address("Gk", "Delhi");
		address.setEmployee(emp1);
		
		Address address2 = new Address("LP", "Delhi");
		address2.setEmployee(emp1);
		
		Address officeAddress = new Address("DLF", "Gurugram");
		officeAddress.setEmployee(emp1);
		Set<Address> addresses = new HashSet<>();
		addresses.add(address); addresses.add(address2); addresses.add(officeAddress);
		
		emp1.setAddresses(addresses);
		// emp1.setAddress(address);
		repo.addEmployee(emp1);
		

	}
	

	@Test
	public void findEmployee() {
		Employee employee = repo.findEmployee(40);
		System.out.println(employee);
		
//		employee.setName("ZZZZ");
		
		System.out.println(employee.getAddresses());
//		 System.out.println(employee.getAddress());
	}

}
