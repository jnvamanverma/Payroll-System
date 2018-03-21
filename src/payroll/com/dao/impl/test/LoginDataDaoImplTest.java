package payroll.com.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.entity.LoginData;

public class LoginDataDaoImplTest {

	LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
	
	LoginData loginData=new LoginData("128","employee0123","employee",0);
	LoginData loginData1=new LoginData("128","helloworld0123","admin",0);
	
	

 

	
	@Test
	public void testAddLoginData() {
		assertEquals("FAIL", loginDataDaoImpl.addLoginData(null));
		assertEquals("ROW INSERTED",loginDataDaoImpl.addLoginData(loginData));
	}

  
	@Test
	public void testEditLoginData() {
		assertEquals("FAIL", loginDataDaoImpl.addLoginData(null));
		assertEquals("ROW UPDATED",loginDataDaoImpl.editLoginData(loginData1));
	}



    
	@Test
	public void testSearchLoginDataString() {
		assertNotNull(loginDataDaoImpl.searchLoginData("128"));
		assertTrue(loginData1.equals(loginDataDaoImpl.searchLoginData("128")));
	}


    
	@Test
	public void testSearchLoginDataLoginData() {
		assertNotNull(loginDataDaoImpl.searchLoginData(loginData1));
	}
	
    
    
	@Test
	public void testDeleteLoginData() {
		assertEquals("FAIL", loginDataDaoImpl.deleteLoginData(null));
		assertEquals("ROW DELETED SUCCESSFULLY",loginDataDaoImpl.deleteLoginData("128"));
	}

}
