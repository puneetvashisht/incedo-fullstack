package com.incedo.firstspringdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
//	List<Employee> employees  = new ArrayList<>();
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	// fetch
	@GetMapping(path="/employees")
	public List<Employee> getEmployees() {
//		return employees;
		return employeeRepository.findAll();		
	}
	
	
	@GetMapping(path="/employees/{id}", produces = {MediaType.TEXT_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Optional<Employee> employeeFound = employeeRepository.findById(id);
		if(employeeFound.isPresent()) {
			return new ResponseEntity<Employee>(employeeFound.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	
//	http://localhost:8080/employees/23
//		
//	http://localhost:8080/employees?name=Ravi
//	http://localhost:8080/employees?salary=33333
	
	@GetMapping(path="/employees/find", produces = {MediaType.TEXT_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> getEmployeeByName(@RequestParam("name") String name, @RequestParam("id") int id ) {
		Employee employeeFound = employeeRepository.findByNameAndId(name, id);
		return new ResponseEntity<Employee>(employeeFound, HttpStatus.OK);
		
//		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path="/employees/salarygt")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam("salary") double salary) {
		List<Employee> employeeFound = employeeRepository.findBySalaryGreaterThan(salary);
		System.out.println(employeeFound);
		return new ResponseEntity<List<Employee>>(employeeFound, HttpStatus.OK);
		
//		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path="/employees/namelike")
	public ResponseEntity<List<Employee>> getEmployeeByNameLike(@RequestParam("name") String name) {
		List<Employee> employeeFound = employeeRepository.findEmployeeByNameLike(name);
		System.out.println(employeeFound);
		return new ResponseEntity<List<Employee>>(employeeFound, HttpStatus.OK);
		
//		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	// create
	@PostMapping(path="/employees")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee e) {
//		employees.add(e);
		employeeRepository.save(e);
		
		if(e.name.equals("Example")) {
			throw new RuntimeException("Some issue");
		}
		
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	// delete
	@DeleteMapping(path="/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		System.out.println("Id: " + id);
		employeeRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
//		List<Employee> remainingEmployees = employees.stream()
//		.filter((e)-> (e.id != id))
//		.collect(Collectors.toList());		
//		this.employees = remainingEmployees;
//		return employees;	
	}
	
	// update or put for complete replacement
	@PatchMapping(path="/employees")
	public ResponseEntity<Void> updateEmployeeSalary(@RequestBody Employee employee) {
		Optional<Employee> employeeFound =  employeeRepository.findById(employee.getId());
		if(employeeFound.isPresent()) {
			Employee e  = employeeFound.get();
			e.setSalary(employee.getSalary());
			employeeRepository.save(e);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		
	}

}
