package payroll.com.entity;

public class Tax {

	private String userId=null;
	private double incomeTax=0;
	private double serviceTax=0;
	private double pfDeduction=0;
	private double totalEarning=0;
	private double totalDeduction=0;
	private double netSalary=0;
	
	public Tax(String userId, double incomeTax, double serviceTax,double pfDeduction,double totalEarning,double totalDeduction,double netSalary) {
		super();
		this.userId = userId;
		this.incomeTax = incomeTax;
		this.serviceTax = serviceTax;
		this.pfDeduction=pfDeduction;
		this.totalEarning=totalEarning;
		this.totalDeduction=totalDeduction;
		this.netSalary=netSalary;
	}

	public Tax() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public double getTotalEarning() {
		return totalEarning;
	}

	public void setTotalEarning(double totalEarning) {
		this.totalEarning = totalEarning;
	}

	public double getTotalDeduction() {
		return totalDeduction;
	}

	public void setTotalDeduction(double totalDeduction) {
		this.totalDeduction = totalDeduction;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	
}
