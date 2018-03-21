package payroll.com.service;

import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;

public interface UserService {

	public boolean login(LoginData user);

	public String getUserType(String id);
	
	public boolean changePassword(LoginData loginData);

	boolean aadharVerification(Employee employee);
	
	public boolean logOut(String userId);
}
