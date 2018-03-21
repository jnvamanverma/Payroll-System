package payroll.com.extra.service.classes;

public class SalaryCalculations {

	double incomeTax=0;
	double serviceTax=0;
	double pfDeduction=0;
	double totalDeducions=0;
	double totalEarnings=0;
	double netSalary=0;
	String paySlipId=null;
	public SalaryCalculations(double incomeTax, double serviceTax, double pfDeduction, double totalDeducions,
			double totalEarnings, double netSalary, String paySlipId) {
		super();
		this.incomeTax = incomeTax;
		this.serviceTax = serviceTax;
		this.pfDeduction = pfDeduction;
		this.totalDeducions = totalDeducions;
		this.totalEarnings = totalEarnings;
		this.netSalary = netSalary;
		this.paySlipId=paySlipId;
	}
	public SalaryCalculations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}
	public double getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(double serviceTax) {
		this.serviceTax = serviceTax;
	}
	public double getPfDeduction() {
		return pfDeduction;
	}
	public void setPfDeduction(double pfDeduction) {
		this.pfDeduction = pfDeduction;
	}
	public double getTotalDeducions() {
		return totalDeducions;
	}
	public void setTotalDeducions(double totalDeducions) {
		this.totalDeducions = totalDeducions;
	}
	public double getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	public String getPaySlipId() {
		return paySlipId;
	}
	public void setPaySlipId(String paySlipId) {
		this.paySlipId = paySlipId;
	}
	
	
	
	
}
