package com.incedo.firstspringdemo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Employee findByNameAndId(String name, int id);
	List<Employee> findBySalaryGreaterThan(double salary);
	
	
	@Query("select e from Employee e where e.name LIKE ?1")
	List<Employee> findEmployeeByNameLike(String name);

}
