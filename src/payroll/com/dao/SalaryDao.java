package payroll.com.dao;

import payroll.com.entity.Salary;

public interface SalaryDao {
	String addSalary(Salary salary);
	public String editSalary(Salary salary);
	public String deleteSalary(String Id);
	public Salary searchSalary(String id);
}
