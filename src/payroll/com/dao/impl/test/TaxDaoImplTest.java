package payroll.com.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.com.dao.impl.TaxDaoImpl;
import payroll.com.entity.Tax;

public class TaxDaoImplTest {
	
	Tax tax=new Tax("128",200,1254,120,12000,600,11000);
	Tax tax1=new Tax("128",300,1154,520,12000,600,11000);
    TaxDaoImpl taxDaoImpl=new TaxDaoImpl();

    
	@Test
	public void testAddTax() {
		assertEquals("FAIL", taxDaoImpl.addTax(null));
		assertEquals("ROW INSERTED",taxDaoImpl.addTax(tax));
	}
    
	@Test
	public void testEditTax() {
		assertEquals("FAIL", taxDaoImpl.editTax(null));
		assertEquals("ROW UPDATED",taxDaoImpl.editTax(tax1));
	}
   
	@Test
	public void testDeleteTax() {
		assertEquals("FAIL", taxDaoImpl.deleteTax(null));
		assertEquals("ROW DELETED SUCCESSFULLY",taxDaoImpl.deleteTax("128"));
	}
    
	@Test
	public void testSearchTax() {
		assertNull(taxDaoImpl.searchTax(null));
		assertNotNull(taxDaoImpl.searchTax("128"));
	}

}
