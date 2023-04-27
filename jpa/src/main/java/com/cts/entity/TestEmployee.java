package com.cts.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestEmployee {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jbd-pu");
//    EntityManager em = emf.createEntityManager()
	
	void addEmployee(Employee emp){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
//		
		if(emp.id > 0) {
			tx.rollback();
		}
		
		em.persist(emp);
		tx.commit();
		em.close();
	}
	
	void removeEmployee(int id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee emp = em.find(Employee.class, id);
		em.remove(emp);
		tx.commit();
		em.close();
	}
	
	void updateEmployee(int id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee emp = em.find(Employee.class, id);
		
		tx.commit();
		em.close();
		
		emp.name = "Priya";
	}
	
	Employee fetchEmployee(int id){
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, id);
		em.close();
		return emp;
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee("Priya", 33434.34);
//		emp1.id = 34;
		TestEmployee testEmployee = new TestEmployee();
//		testEmployee.addEmployee(emp1);
		
		testEmployee.updateEmployee(40);
		
//		Employee fetchedEmployee = testEmployee.fetchEmployee(2);
//		System.out.println(fetchedEmployee);

	}

}
