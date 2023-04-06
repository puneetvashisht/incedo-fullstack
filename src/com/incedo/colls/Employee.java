package com.incedo.colls;

public class Employee{
	
	public int id;
	String name;
	public double salary;
	static final String companyName = "INCEDO";
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public void incrementSalary() throws InterruptedException {
		Thread.sleep(2000);
		this.salary *= 1.1;
		System.out.println("Salary incremented by thread: " + Thread.currentThread().getName());
	}

//	@Override
//	 public boolean equals(Object obj) {
//		Employee e = (Employee)obj;
//	       return this.id == e.id && this.name.equals(e.name);
//	 }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}


//	@Override
//	public int compareTo(Employee o) {
//		return this.id - o.id;
//	}
	
	

}
