package payroll.com.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.entity.Employee;

public class EmployeeDaoImplTest {
	
	EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
	Employee employee=new Employee("128", "akhil", "kumar", new java.util.Date(), "male", "xyz@gmail.com","jul12","9714771417","part-time", "123456789123","manager","cse","123456789123");
	Employee employee1=new Employee("128", "anil", "tyagi", new java.util.Date(), "male", "xyz@gmail.com","jul12","9714771417","part-time", "123456789123","manager","cse","123456789123");

	
	@Test
	public void testAddEmployee() {
		assertEquals("FAIL",employeeDaoImpl.addEmployee(null));
		assertEquals("ROW INSERTED", employeeDaoImpl.addEmployee(employee));
	}
	
	@Test
	public void testEditEmployee() {
		assertEquals("FAIL",employeeDaoImpl.editEmployee(null));
		assertEquals("ROW UPDATED",employeeDaoImpl.editEmployee(employee1));
	}
    
	@Test
	public void testDeleteEmployee() {
      assertEquals("FAIL", employeeDaoImpl.deleteEmployee(null));
      assertEquals("ROW DELETED SUCCESSFULLY",employeeDaoImpl.deleteEmployee("128"));
	}
    
	@Test
	public void testSearchEmployeeString() {
		assertNotNull(employeeDaoImpl.searchEmployee("128"));
	}
    
	@Test
	public void testSearchEmployeeEmployee() {
		assertNotNull(employeeDaoImpl.searchEmployee(employee));
	}
    
	@Test
	public void testGetAll() {
		assertNotNull(employeeDaoImpl.getAll());
	}

}
