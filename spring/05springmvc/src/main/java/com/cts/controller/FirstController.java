package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepository;

@Controller
public class FirstController {
	
	@Autowired
	EmployeeRepository repository;
	
	@RequestMapping(path="/hello", method=RequestMethod.GET)
	public String hello(Model model){
//		if condition 1 return "success"
//		else return "login"
		// service and use the return value as some data
		model.addAttribute("message", "Welcome user to this session");
		model.addAttribute("user", "Ravi");
		System.out.println("Hello invoked...");
		return "test";
	}

	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public String fetchEmployees(Model model){
		List<Employee> employees = repository.findEmployees();
		System.out.println("Employees the controller");
		System.out.println(employees);
		model.addAttribute("employees", employees);
		return "employees";
	}
	

	
	@RequestMapping(path="/employee", method=RequestMethod.POST)
	public String addEmployees(Model model,  @RequestParam(value="name", required=true) String name, 
	    @RequestParam(value="salary", required=false) Double salary){
		Employee employee = new Employee(name, salary);
		repository.addEmployee(employee);
		model.addAttribute("message", "Successfully added, " + employee.getName());
		return "employee";
	}
	
	

}
