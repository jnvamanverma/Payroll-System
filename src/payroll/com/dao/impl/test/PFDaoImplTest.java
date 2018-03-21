package payroll.com.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.com.dao.impl.PFDaoImpl;
import payroll.com.entity.PF;

public class PFDaoImplTest {
	PF pf=new PF("128","12345678912345",231,12);
	PF pf1=new PF("128","12345678912345",2500,12);
    PFDaoImpl daoImpl=new PFDaoImpl();
    
    
	@Test
	public void testAddPF() {
		assertEquals("FAIL", daoImpl.addPF(null));
		assertEquals("ROW INSERTED", daoImpl.addPF(pf));
	}
    
	@Test
	public void testEditPF() {
		assertEquals("FAIL", daoImpl.editPF(null));
		assertEquals("ROW UPDATED", daoImpl.editPF(pf1));
	}
    
	@Test
	public void testDeletePF() {
		assertEquals("FAIL", daoImpl.deletePF(null));
		assertEquals("ROW DELETED SUCCESSFULLY", daoImpl.deletePF("128"));
	}
    
	@Test
	public void testSearchPF() {
		assertNull(daoImpl.searchPF(null));
		assertNotNull(daoImpl.searchPF("128"));
	}

}
