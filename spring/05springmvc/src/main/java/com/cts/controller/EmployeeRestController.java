package com.cts.controller;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeRestController {
	
	@Autowired
	EmployeeRepository repository;
	

	@RequestMapping(path="/employees", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Employee>>fetchEmployees(){
		List<Employee> employees = repository.findEmployees();
		System.out.println("Employees the REST controller");
		System.out.println(employees);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
//	    return employees;
	}
	
	@RequestMapping(path="/employee/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Employee>fetchEmployee(@PathVariable("id") int id){
		Employee employee = repository.findEmployee(id);
		System.out.println("Employe the REST controller");
		System.out.println(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//	    return employees;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee) {
		System.out.println("Creating Employee " + employee);
		
		try{
			Employee emp = repository.findByName(employee.getName());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		catch(NoResultException nre){
			repository.addEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}	
	
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
		System.out.println("Creating Employee " + employee);
		
		try{
			repository.updateEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		catch(NoResultException nre){
			repository.addEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}	
	
	}
	
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id){
		System.out.println("ID recieved : " + id);
		repository.removeEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.GONE);
	}



}
