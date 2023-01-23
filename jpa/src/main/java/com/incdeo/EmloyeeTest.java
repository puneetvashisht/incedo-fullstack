package com.incdeo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class EmloyeeTest {
	
	
	// 1. Create entity manager
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jbd-pu");
	
	void addEmployee(Employee emp){
//		2. EntityManager represents connection to db
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(emp);
		tx.commit();
		em.close();
	}
	
	 Employee findEmployee(int id){
//		2. EntityManager represents connection to db
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Employee emp = em.find(Employee.class, id);
//		
		em.remove(emp);
		
		tx.commit();
		em.close();
		
//		emp.setSalary(66666);
		return emp;
	}
	 
	 List<Employee> findEmployeeGreaterThanSalary(double salary){
//			2. EntityManager represents connection to db
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			TypedQuery<Employee> query = em.createNamedQuery("findSalaryGreaterThan", Employee.class);
			query.setParameter("sal", salary);
			List<Employee> employees = query.getResultList();
			
			tx.commit();
			em.close();

			return employees;
		}
	
	
	public static void main(String[] args) {
//		Employee e = new Employee( "Priya", 323232);
//		new EmloyeeTest().addEmployee(e);
		
		List<Employee> e = new EmloyeeTest().findEmployeeGreaterThanSalary(20000);
		
		System.out.println(e);
//		
	}

}
