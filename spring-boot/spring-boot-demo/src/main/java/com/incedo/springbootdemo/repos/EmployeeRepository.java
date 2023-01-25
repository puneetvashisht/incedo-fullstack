package com.incedo.springbootdemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incedo.springbootdemo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
