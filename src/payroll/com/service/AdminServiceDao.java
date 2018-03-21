package payroll.com.service;

import java.util.Date;

import payroll.com.entity.Employee;
import payroll.com.entity.Salary;

public interface AdminServiceDao {

	public boolean hireEmployee(Employee employee, Salary salary );
	public boolean fireEmployee(String userId);
	public boolean editDetailsAdmin(Employee employee, Salary salary );
	public boolean makeAdmin(String userId);
	//public ArrayList<Employee> getUserId(LoginData loginData,Employee employee,Address address);
	public String generateUserId(String name);
	public void generatePaySlip(Date date2);
	public String generateDepartmentId(String name);


}
