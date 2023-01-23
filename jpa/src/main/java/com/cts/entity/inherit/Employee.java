package com.cts.entity.inherit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Employee_ID_JND")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorValue(value="1")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	public Employee(){
		
	}
	public Employee(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	
	
}
