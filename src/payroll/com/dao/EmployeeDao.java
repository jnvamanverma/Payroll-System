package payroll.com.dao;

import java.util.ArrayList;

import payroll.com.entity.Employee;

public interface EmployeeDao {
	String addEmployee(Employee employee);
	public String editEmployee(Employee employee);
	public String deleteEmployee(String Id);
	public Employee searchEmployee(String Id);
	public ArrayList<Employee> searchEmployee(Employee employee);
	public ArrayList<Employee> getAll();
}
