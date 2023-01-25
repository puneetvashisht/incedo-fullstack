package com.cts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQuery(name="findEmployeeByName", query="select e from Employee e where e.name=:name")
@NamedQuery(name="findEmployeeBySalary", query="select e from Employee e where e.salary > :salary")
@NamedQuery(name="findEmployees", query="from Employee e")
@XmlRootElement
public class Employee {
	
	public Employee(){}

	public Employee(String name) {
		super();
		this.name = name;
	}
	public Employee(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="EMP_SALARY")
	Double salary;
	

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	
	
}
