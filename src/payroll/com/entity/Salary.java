package payroll.com.entity;

public class Salary {
	private String userId=null;
	private double netSalary=0;
	private double bonus=0;
	private double allowance=0;
	private double basicSalary=0;
	
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Salary(String userId, double netSalary, double bonus, double allowance, double basicSalary) {
		super();
		this.userId = userId;
		this.netSalary = netSalary;
		this.bonus = bonus;
		this.allowance = allowance;
		this.basicSalary = basicSalary;
	}
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getAllowance() {
		return allowance;
	}
	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	
}
