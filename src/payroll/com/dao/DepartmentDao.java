package payroll.com.dao;

import payroll.com.entity.Department;


public interface DepartmentDao {
	String addDepartment(Department department);
	public String editDepartment(Department department );
	public String deleteDepartment(String Id);
	public Department searchDepartment(String deptName);
}
