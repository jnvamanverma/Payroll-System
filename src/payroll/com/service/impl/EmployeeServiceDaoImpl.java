package payroll.com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import payroll.com.dao.impl.AddressDaoImpl;
import payroll.com.dao.impl.AttendanceSheetDaoImpl;
import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.dao.impl.PFDaoImpl;
import payroll.com.dao.impl.PaySlipDaoImpl;
import payroll.com.dao.impl.SalaryDaoImpl;
import payroll.com.dao.impl.TaxDaoImpl;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.Address;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.entity.PF;
import payroll.com.entity.PaySlip;
import payroll.com.entity.Salary;
import payroll.com.entity.Tax;
import payroll.com.extra.service.classes.CountAttendance;
import payroll.com.service.EmployeeServiceDao;

public class EmployeeServiceDaoImpl implements EmployeeServiceDao {
	
   static Connection connection;
   LoginDataDaoImpl daoImpl=new LoginDataDaoImpl();
	AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
	EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
	PFDaoImpl pfDaoImpl=new PFDaoImpl();
	SalaryDaoImpl salaryDaoImpl=new SalaryDaoImpl();
	TaxDaoImpl taxDaoImpl=new TaxDaoImpl();
	AttendanceSheetDaoImpl attendanceSheetDaoImpl=new AttendanceSheetDaoImpl();
	PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
	LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();

	public EmployeeServiceDaoImpl() {
	connection=DBUtil.getConnection();
}

	@Override
	public boolean getResign(String userId) {
		if(userId==null)
			return false;
		if(userId.isEmpty())
			return false;
		
	//	LoginDataDaoImpl daoImpl=new LoginDataDaoImpl();
		LoginData loginData=daoImpl.searchLoginData(userId);
		if(loginData==null)
		{
			System.out.println("user id not found");
			return false;
		}
		
		//AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
		//EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		//PFDaoImpl pfDaoImpl=new PFDaoImpl();
		//SalaryDaoImpl salaryDaoImpl=new SalaryDaoImpl();
		//TaxDaoImpl taxDaoImpl=new TaxDaoImpl();
		
		System.out.println(addressDaoImpl.deleteAddress(userId));
		System.out.println(employeeDaoImpl.deleteEmployee(userId));
		System.out.println(pfDaoImpl.deletePF(userId));
		System.out.println(salaryDaoImpl.deleteSalary(userId));
		System.out.println(taxDaoImpl.deleteTax(userId));
		System.out.println(attendanceSheetDaoImpl.deleteAttendanceSheet(userId));
		System.out.println(paySlipDaoImpl.deletePayslipByUserId(userId));
		System.out.println(daoImpl.deleteLoginData(userId));
		
		
		return true;
	}

	@Override
	public boolean editdetails(LoginData loginData, Employee employee, Address address, PF pf) {
		//LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
		//EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		//AddressDaoImpl addressDaoImpl=new AddressDaoImpl();
		//PFDaoImpl pfDaoImpl=new PFDaoImpl();
		
		String result;
		result=employeeDaoImpl.editEmployee(employee);
		if(result.equals("FAIL")||result.equals("UPDATION ERROR...  "))
			return false;
		result=addressDaoImpl.editAddress(address);
		if(result.equals("FAIL")||result.equals("UPDATION ERROR...  "))
		return false;
		result=pfDaoImpl.editPF(pf);
		if(result.equals("FAIL")||result.equals("UPDATION ERROR...  "))
		return false;
		result=loginDataDaoImpl.editLoginData(loginData);
		if(result.equals("FAIL")||result.equals("UPDATION ERROR...  "))
			return false;
		
		
		return true;
	}

	@Override
	public String generatePaySlipId(String month) {
		String paySlipId=Character.toString(month.charAt(0))+Character.toString(month.charAt(1))+Character.toString(month.charAt(2));
		String sql="select  seq_payslipid.nextval from dual";
		try {
			PreparedStatement ps  = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				paySlipId=paySlipId+Integer.toString(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("error in generating userid");
		}
		return paySlipId;
	}

	@Override
	public void getSalaryCalcultions(Salary salary, CountAttendance countAttendance) {
		double incomeTax,serviceTax,pfDeduction,totalDeduction,totalEarnings,netSalary;
		
		//PFDaoImpl pfDaoImpl=new PFDaoImpl();
		PF pf=pfDaoImpl.searchPF(salary.getUserId());
		int totalDays=countAttendance.getCl()+countAttendance.getEl()+countAttendance.getWorkingDays();
		double basicPay=totalDays*(salary.getBasicSalary()/30);
		incomeTax=(0.1)*basicPay;
		serviceTax=(0.08)*basicPay;
		pfDeduction=pf.getPfPercentage()/100*basicPay;
		double pfAmount=pf.getPfAmount()+pfDeduction;
		pf.setPfAmount(pfAmount);
		pfDaoImpl.editPF(pf);
		
	    totalEarnings=salary.getBonus()+salary.getAllowance()+basicPay;
	    totalDeduction=pfDeduction+incomeTax+serviceTax;
	    
	    netSalary=totalEarnings-totalDeduction;
	    
	    Date date=new Date();
	    String date1=date.toString();
	    String subDate[]=date1.split(" ");
	    
	   // EmployeeServiceDaoImpl employeeServiceDaoImpl=new EmployeeServiceDaoImpl();
	    PaySlip paySlip=new PaySlip();
	    paySlip.setUserId(salary.getUserId());
	    paySlip.setAmount(netSalary);
	    paySlip.setPaidDate(new java.util.Date());
	    String paySlipId=generatePaySlipId(subDate[1]);//employeeServiceDaoImpl.
	    paySlip.setPaySlipId(paySlipId);
	   // PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
	    paySlipDaoImpl.addPaySlip(paySlip);
	    
	    Tax tax=new Tax(salary.getUserId(), incomeTax, serviceTax, pfDeduction, totalEarnings, totalDeduction, netSalary);
	    taxDaoImpl.addTax(tax);
	    
	    //SalaryCalculations salaryCalculations=new SalaryCalculations(incomeTax, serviceTax, pfDeduction, totalDeduction, totalEarnings, netSalary, paySlipId);
		
		//return salaryCalculations;
	}

}
