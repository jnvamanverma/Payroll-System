package payroll.com.service;

import payroll.com.entity.Address;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.entity.PF;
import payroll.com.entity.Salary;
import payroll.com.extra.service.classes.CountAttendance;

public interface EmployeeServiceDao {
	
	public boolean getResign(String userId);
	public boolean editdetails(LoginData loginData,Employee employee,Address address,PF pf);
	public String generatePaySlipId(String month);
	public void getSalaryCalcultions(Salary salary,CountAttendance countAttendance);


}
