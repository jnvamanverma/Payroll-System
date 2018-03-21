package payroll.com.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.com.dao.impl.SalaryDaoImpl;
import payroll.com.entity.Salary;

public class SalaryDaoImplTest {
	
	Salary salary = new Salary("128", 19000, 150, 120, 17000);
	Salary salary1 = new Salary("128", 19000, 150, 1120, 17000);
    SalaryDaoImpl salaryDaoImpl = new SalaryDaoImpl();

    
	@Test
	public void testAddSalary() {
		assertEquals("FAIL",salaryDaoImpl.addSalary(null));
		assertEquals("ROW INSERTED", salaryDaoImpl.addSalary(salary));
	}
    
	@Test
	public void testEditSalary() {
		assertEquals("FAIL",salaryDaoImpl.editSalary(null));
		assertEquals("ROW UPDATED", salaryDaoImpl.editSalary(salary1));
	}
    
	@Test
	public void testDeleteSalary() {
		assertEquals("FAIL",salaryDaoImpl.deleteSalary(null));
		assertEquals("ROW DELETED SUCCESSFULLY", salaryDaoImpl.deleteSalary("128"));
	}
    
	@Test
	public void testSearchSalary() {
		assertNull(salaryDaoImpl.searchSalary(null));
		assertNotNull(salaryDaoImpl.searchSalary("128"));
	}

}
