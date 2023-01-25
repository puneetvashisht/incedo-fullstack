package com.incedo.springbootdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.springbootdemo.entities.Employee;
import com.incedo.springbootdemo.repos.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
//	List<Employee> employees = new ArrayList<>();
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee e) {
		System.out.println(e);
//		employees.add(e);
		employeeRepository.save(e);
	}
	
	@GetMapping("/employees")
	public List<Employee> fetchAllEmployees(){
//		return employees;
		return employeeRepository.findAll();
	}

}
