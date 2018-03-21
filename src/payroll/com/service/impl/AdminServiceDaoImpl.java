package payroll.com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import payroll.com.dao.impl.AddressDaoImpl;
import payroll.com.dao.impl.AttendanceSheetDaoImpl;
import payroll.com.dao.impl.DepartmentDaoImpl;
import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.dao.impl.PFDaoImpl;
import payroll.com.dao.impl.PaySlipDaoImpl;
import payroll.com.dao.impl.SalaryDaoImpl;
import payroll.com.dao.impl.TaxDaoImpl;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.Address;
import payroll.com.entity.Department;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.entity.PF;
import payroll.com.entity.PaySlip;
import payroll.com.entity.Salary;
import payroll.com.entity.Tax;
import payroll.com.extra.service.classes.CountAttendance;
import payroll.com.extra.service.classes.GiveAttendendence;
import payroll.com.service.AdminServiceDao;

public class AdminServiceDaoImpl implements AdminServiceDao{
	
	static Connection connection;

	public AdminServiceDaoImpl() {
		connection=DBUtil.getConnection();
	}

	

	/*
	LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
	AdminServiceDaoImpl adminServiceDaoImpl=new AdminServiceDaoImpl();
	EmployeeServiceDaoImpl employeeServiceDaoImpl=new EmployeeServiceDaoImpl();
	AttendanceSheetDaoImpl attendanceSheetDaoImpl=new AttendanceSheetDaoImpl();
	DepartmentDaoImpl departmentDaoImpl=new DepartmentDaoImpl();
	EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
	SalaryDaoImpl salaryDaoImpl=new SalaryDaoImpl();
	AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
	PFDaoImpl pfDaoImpl=new PFDaoImpl();
	TaxDaoImpl taxDaoImpl=new TaxDaoImpl();
	PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
	*/
	
	public static void main(String[] args) {
		//AdminServiceDaoImpl daoImpl=new AdminServiceDaoImpl();
		//System.out.println(daoImpl.generateUserId("aman"));
		//System.out.println(daoImpl.generateDepartmentId("cse"));
	}

	@Override
	public boolean hireEmployee(Employee employee, Salary salary) {
		
	   boolean  result=false;
	   if(employee.getFirstName()==null)
		    return false;
	   else
		   result=true;
		 
	   LoginData loginData=new LoginData();
	   AdminServiceDaoImpl adminServiceDaoImpl=new AdminServiceDaoImpl();
	   LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
	   EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
	   SalaryDaoImpl salaryDaoImpl=new SalaryDaoImpl();
	   DepartmentDaoImpl departmentDaoImpl=new DepartmentDaoImpl();
		String userId=adminServiceDaoImpl.generateUserId(employee.getFirstName());
		employee.setUserId(userId);
		salary.setUserId(userId);
		loginData.setUserId(userId);
		loginData.setLoginStatus(0);
		loginData.setPassword("employee");
		loginData.setUserType("employee");
		
		PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
		EmployeeServiceDaoImpl employeeServiceDaoImpl=new EmployeeServiceDaoImpl();
		Date date=new Date();
		String str=date.toString();
		String S[]=str.split(" ");
		String paySlipId=employeeServiceDaoImpl.generatePaySlipId(S[1]);
		employee.setPaySlipId(paySlipId);
		PaySlip paySlip=new PaySlip(paySlipId, userId, date, 0);
		Tax tax=new Tax(userId,0,0,0,0,0,0);
		Address address=new Address(userId,"none","none",0,"none","none");
		PF pf=new PF(userId,"0",0,0);
		TaxDaoImpl taxDaoImpl=new TaxDaoImpl();
        AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
        PFDaoImpl pfDaoImpl=new PFDaoImpl();
		
		System.out.println(loginDataDaoImpl.addLoginData(loginData));
		System.out.println(employeeDaoImpl.addEmployee(employee));
		System.out.println(salaryDaoImpl.addSalary(salary));
		System.out.println(paySlipDaoImpl.addPaySlip(paySlip));
		System.out.println(taxDaoImpl.addTax(tax));
		System.out.println(addressDaoImpl.addAddress(address));
		System.out.println(pfDaoImpl.addPF(pf));
		
		Department department2=departmentDaoImpl.searchDepartment(employee.getDepartment());
		if(department2==null)
		{
			Department department=new Department();
			String depId=adminServiceDaoImpl.generateDepartmentId(employee.getDepartment());
			department.setDepId(depId);
			department.setDepName(employee.getDepartment());
			System.out.println(departmentDaoImpl.addDepartment(department));
		}
		
		GiveAttendendence giveAttendendence=new GiveAttendendence();
		giveAttendendence.insertAttendence(userId);
	
		return result;
	}



	
	@Override
	public boolean fireEmployee(String userId) {
		if(userId==null)
			return false;
		if(userId.isEmpty())
			return false;
		LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
		AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		PFDaoImpl pfDaoImpl=new PFDaoImpl();
		SalaryDaoImpl salaryDaoImpl=new SalaryDaoImpl();
		TaxDaoImpl taxDaoImpl=new TaxDaoImpl();
		LoginData loginData=loginDataDaoImpl.searchLoginData(userId);
		if(loginData==null)
		{
			System.out.println("user id not found");
			return false;
		}
		
		AttendanceSheetDaoImpl attendanceSheetDaoImpl=new AttendanceSheetDaoImpl();
		PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
		System.out.println(addressDaoImpl.deleteAddress(userId));
		System.out.println(employeeDaoImpl.deleteEmployee(userId));
		System.out.println(pfDaoImpl.deletePF(userId));
		System.out.println(salaryDaoImpl.deleteSalary(userId));
		System.out.println(taxDaoImpl.deleteTax(userId));
		System.out.println(attendanceSheetDaoImpl.deleteAttendanceSheet(userId));
		System.out.println(paySlipDaoImpl.deletePayslipByUserId(userId));
		System.out.println(loginDataDaoImpl.deleteLoginData(userId));
		
		return true;
	}



	@Override
	public boolean editDetailsAdmin(Employee employee, Salary salary) {
		
		   boolean result=false;
		   if(employee.getFirstName()==null)
			   return result;
		   else
			   result=true;

		   EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		   SalaryDaoImpl salaryDaoImpl=new SalaryDaoImpl();
		   DepartmentDaoImpl departmentDaoImpl=new DepartmentDaoImpl();
		   
			System.out.println(employeeDaoImpl.editEmployee(employee));
			System.out.println(salaryDaoImpl.editSalary(salary));
			
			Department department2=departmentDaoImpl.searchDepartment(employee.getDepartment());
			if(department2==null)
			{
				Department department=new Department();
				String depId=generateDepartmentId(employee.getDepartment());//adminServiceDaoImpl.
				department.setDepId(depId);
				department.setDepName(employee.getDepartment());
				System.out.println(departmentDaoImpl.addDepartment(department));
			}
			
			
			return result;
		
	}

	@Override
	public boolean makeAdmin(String userId) {
		if(userId==null)
		return false;
		if(userId.isEmpty())
			return false;
		
		LoginData loginData=new LoginData();
		loginData.setUserType("admin");
		loginData.setUserId(userId);
		

		LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
		String result=loginDataDaoImpl.editLoginData(loginData);
		
		if(result.equals("FAIL"))
			return false;
		else 
			return true;
	}

	/*@Override
	public ArrayList<Employee> getUserId(LoginData loginData, Employee employee, Address address) {
		
		ArrayList<Employee>list1=employeeDaoImpl.searchEmployee(employee);
		ArrayList<LoginData>list2=loginDataDaoImpl.searchLoginData(loginData);
		ArrayList<Address>list3=addressDaoImpl.searchAddress(address);
		
		ArrayList<Employee>list=new ArrayList<Employee>();
		return null;
	}
	*/

	@Override
	public String generateUserId(String name) {
		String userId=Character.toString(name.charAt(0))+Character.toString(name.charAt(1));
		String sql="select  seq_userid.nextval from dual";
		try {
			PreparedStatement ps  = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				userId=userId+Integer.toString(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("error in generating userid");
		}
		return userId;
	}

	@Override
	public String generateDepartmentId(String name) {
		String depId=Character.toString(name.charAt(0))+Character.toString(name.charAt(1));
		String sql="select  seq_depid.nextval from dual";
		try {
			PreparedStatement ps  = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				depId=depId+Integer.toString(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("error in generating userid");
		}
		return depId;
	}

	@Override
	public void generatePaySlip(Date date2) {
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		SalaryDaoImpl salaryDaoImpl=new SalaryDaoImpl();
		PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
		EmployeeServiceDaoImpl employeeServiceDaoImpl=new EmployeeServiceDaoImpl();
		AttendanceSheetDaoImpl attendanceSheetDaoImpl=new  AttendanceSheetDaoImpl();
		ArrayList<Employee>list=employeeDaoImpl.getAll();
		Salary salary=null;
		Date date1=null;
		String paySlipId=null;
		PaySlip paySlip=null;
		CountAttendance countAttendance=null;
		
		for (Employee employee : list) {
			salary=salaryDaoImpl.searchSalary(employee.getUserId());
			paySlipId=employee.getPaySlipId();
			paySlip=paySlipDaoImpl.searchPaySlip(paySlipId);
			date1=paySlip.getPaidDate();
			countAttendance=attendanceSheetDaoImpl.countAttendanceSheet(employee.getUserId(), date1, date2);
			employeeServiceDaoImpl.getSalaryCalcultions(salary, countAttendance);
		}
			
	}



}
