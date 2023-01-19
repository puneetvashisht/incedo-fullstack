package com.incedo.colls;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

//@FunctionalInterface
//interface Condition {
//	boolean test(Employee e);
//}

//class NamewithRCondition implements Condition{
//
//	@Override
//	public boolean test(Employee e) {
//		return e.name.startsWith("R");
//	}
//	
//}

public class FindEmployeeDemo {
	
	
	
//	Condition condition1 = (e) ->  true;
	
	
//	public static void printEmployees(List<Employee> employees, Condition condition) {
//		for(Employee e : employees) {
//			if(condition.test(e)) {
//				System.out.println(e);
//			}	
//		}
//	}

	public static void printEmployees(List<Employee> employees, Predicate<Employee> condition, Consumer<Employee> consumer) {
		for(Employee e : employees) {
			if(condition.test(e)) {
//				System.out.println(e);
				consumer.accept(e);
			}	
		}
	}
	public static void main(String[] args) {
		
		
		BiFunction<String, String, Integer> bifunction = (s1, s2) -> (s1.length() + s2.length());
		
		Integer b = bifunction.apply("abc", "xyz");
		
		System.out.println(b);
		
		Employee e1 = new Employee(11, "Ravi", 3433);
		Employee e4 = new Employee(11, "Ravi S", 3433);
		Employee e2 =new Employee(2, "Priya", 45454);
		Employee e3 =new Employee(12, "Rahul", 25454);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		
		// Print all the employees
		System.out.println("----- Printing all -------");
		
//		printEmployees(employees)
//		for(Employee e : employees) {
//			System.out.println(e);
//		}
//		printEmployees(employees, new Condition() {
//			@Override
//			public boolean test(Employee e) {
//				return true;
//			}		
//		});
		
		printEmployees(employees, (e) ->  true, (e)->System.out.println(e));
		
		
		// Print employee with name starting with R
		System.out.println("----- Printing employees starting with R -------");
//		for(Employee e : employees) {
//			if(e.name.startsWith("R")) {
//				System.out.println(e);
//			}	
//		}
//		printEmployees(employees, new NamewithRCondition());
		printEmployees(employees, (e) ->  e.name.startsWith("R") , (e)->System.out.println(e));
		
		// Print employees with salary < 10000
		System.out.println("----- Printing employees with salary < 10000 -------");
		printEmployees(employees, (e) ->  e.salary < 10000 , (e)->System.out.println(e));
//		for(Employee e : employees) {
//			if(e.salary < 10000) {
//				System.out.println(e);
//			}	
//		}

	}

}
