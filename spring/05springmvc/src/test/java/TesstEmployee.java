

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TesstEmployee {

	@Autowired
	EmployeeRepository repo;
	
//	@Test
	public void testInsertingEmployee() {
		Employee emp = new Employee("Arun");
		emp.setSalary(20000d);
		repo.addEmployee(emp);
	
	}
//	@Test
	public void testFindingEmployee() {
		repo.findEmployee(2);
	}
//	@Test
	public void testRemovingEmployee() {
		repo.removeEmployee(2);
	}
	
//	@Test
	public void testUpdatingEmployeeSalary() {
//		repo.updateEmployee(1, 30000d);
	}
//	@Test
	public void testFindingEmployeeByName() {
		Employee emp = repo.findByName("Arun");
		assertEquals("should return one emp with name", emp.getName(), "Arun");
	}
//	@Test
	public void testFindingEmployeesBySalary() {
		List<Employee> employees = repo.findBySalary(25000d);
		assertEquals("should return one emp with name", employees.size(), 1);
	}
	@Test
	public void testFindingEmployees() {
		List<Employee> employees = repo.findEmployees();
//		assertEquals("should return one emp with name", employees.size(), 1);
	}
	

}
