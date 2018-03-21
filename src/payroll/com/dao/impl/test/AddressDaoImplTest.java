package payroll.com.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.com.dao.impl.AddressDaoImpl;
import payroll.com.entity.Address;

public class AddressDaoImplTest {

	AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
	Address address=new Address("128", "begumpur", "new delhi", 110086, "delhi", "new delhi");
	Address address1=new Address("128", "rohini-22", "new delhi", 110086, "delhi", "new delhi");
	
	
	@Test
	public void testAddAddress() {
		assertEquals("FAIL", addressDaoImpl.addAddress(null));
		assertEquals("ROW INSERTED",addressDaoImpl.addAddress(address));
	}
	
	
	@Test
	public void testEditAddress() {
		assertEquals("FAIL", addressDaoImpl.addAddress(null));
		assertEquals("ROW UPDATED",addressDaoImpl.editAddress(address1));
	}
	
	
	@Test
	public void testDeleteAddress() {
		assertEquals("FAIL",addressDaoImpl.deleteAddress(null));
		assertEquals("ROW DELETED SUCCESSFULLY",addressDaoImpl.deleteAddress("128"));
	}
	

	@Test
	public void testSearchAddressString() {
		assertNotNull(addressDaoImpl.searchAddress("128"));
	}
	
	
	@Test
	public void testSearchAddressAddress() {
		assertNotNull(addressDaoImpl.searchAddress(address1));
		
	}

}
