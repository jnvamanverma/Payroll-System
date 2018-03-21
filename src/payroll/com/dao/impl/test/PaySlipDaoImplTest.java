package payroll.com.dao.impl.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import payroll.com.dao.impl.PaySlipDaoImpl;
import payroll.com.entity.PaySlip;

public class PaySlipDaoImplTest {

	PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
	PaySlip paySlip=new PaySlip("jul12","128",new Date(),12230);
	PaySlip paySlip1=new PaySlip("jul12","128",new Date(),13000);
	
	
	@Test
	public void testAddPaySlip() {
		assertEquals("FAIL", paySlipDaoImpl.addPaySlip(null));
		assertEquals("ROW INSERTED",paySlipDaoImpl.addPaySlip(paySlip));
	}
	
	@Test
	public void testEditPaySlip() {
		assertEquals("FAIL",paySlipDaoImpl.editPaySlip(null));
		assertEquals("ROW UPDATED",paySlipDaoImpl.editPaySlip(paySlip1));
	}
	
	@Test
	public void testDeletePaySlip() {
		assertEquals("FAIL",paySlipDaoImpl.deletePaySlip(null));
		assertEquals("ROW DELETED SUCCESSFULLY",paySlipDaoImpl.deletePaySlip("jul12"));
	}
	
	@Test
	public void testSearchPaySlip() {
		assertNull(paySlipDaoImpl.searchPaySlip(null));
		assertNotNull(paySlipDaoImpl.searchPaySlip("jul12"));
	}

}
