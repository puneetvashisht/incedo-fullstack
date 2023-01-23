package com.cts.entity.inherit;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="RegularEmployee_ID_JND")
//@DiscriminatorValue(value="2")
public class RegularEmployee extends Employee {

	double salary;
	public RegularEmployee(){
		
	}
	
	public RegularEmployee(String name, double salary) {
		super(name);
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "RegularEmployee [salary=" + salary + ", id=" + id + ", name=" + name + "]";
	}
	
	

}
