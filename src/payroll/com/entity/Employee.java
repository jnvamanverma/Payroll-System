package payroll.com.entity;

import java.util.Date;

public class Employee {

	// employee information

	private String userId=null;
	private String firstName=null;
	private String lastName=null;
	private Date dob=null;
	private String gender=null;
	private String emailId=null;
	private String paySlipId=null;
	private String mobileNumber=null;
	private String workType=null;
	private String accountNumber=null;
	private String designation=null;
	private String department=null;
	private String aadharnumber=null;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
//
	public Employee(String userId, String firstName, String lastName, Date dob, String gender, String emailId,String paySlipId,
			String mobileNumber, String workType, String accountNumber, String designation, String department, String aadharnumber) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.emailId = emailId;
		this.paySlipId=paySlipId;
		this.mobileNumber = mobileNumber;
		this.workType = workType;
		this.accountNumber = accountNumber;
		this.designation = designation;
		this.department=department;
		this.aadharnumber = aadharnumber;
	}

	
	
	public String getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPaySlipId() {
		return paySlipId;
	}
	
	public void setPaySlipId(String paySlipId) {
		this.paySlipId = paySlipId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	

}
