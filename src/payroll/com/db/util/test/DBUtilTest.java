package payroll.com.db.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.com.db.util.DBUtil;

public class DBUtilTest {

	@Test
	public void testGetConnection() {
		
	 assertNotNull(DBUtil.getConnection());
	}

}
