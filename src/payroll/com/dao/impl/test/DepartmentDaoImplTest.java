package payroll.com.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import payroll.com.dao.impl.DepartmentDaoImpl;
import payroll.com.entity.Department;

public class DepartmentDaoImplTest {

	Department department=new Department("300","electronics");
	Department department1=new Department("300","electrical");
	DepartmentDaoImpl daoImpl=new DepartmentDaoImpl();
	@Ignore
	@Test
	public void testAddDepartment() {
		assertEquals("FAIL", daoImpl.addDepartment(null));
		assertEquals("ROW INSERTED",daoImpl.addDepartment(department));
	}
	@Ignore
	@Test
	public void testEditDepartment() {
		assertEquals("FAIL",daoImpl.editDepartment(null));
		assertEquals("ROW UPDATED", daoImpl.editDepartment(department1));
	}
	@Ignore
	@Test
	public void testDeleteDepartment() {
		assertEquals("FAIL",daoImpl.deleteDepartment(null));
		assertEquals("ROW DELETED SUCCESSFULLY", daoImpl.deleteDepartment("300"));
	}
	@Ignore
	@Test
	public void testSearchDepartment() {
		assertNull(daoImpl.searchDepartment(null));
		assertNotNull(daoImpl.searchDepartment("electrical"));
	}

}
