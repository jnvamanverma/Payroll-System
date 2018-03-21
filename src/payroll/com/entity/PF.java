package payroll.com.entity;

public class PF {

	private String userId=null;
	private String pfAccountNumber=null;
	private double pfAmount=0;
	private double pfPercentage=0;
	
	
	public PF() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PF(String userId, String pfAccountNumber, double pfAmount, double pfPercentage) {
		super();
		this.userId = userId;
		this.pfAccountNumber = pfAccountNumber;
		this.pfAmount = pfAmount;
		this.pfPercentage=pfPercentage;
	}
	
	
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPfAccountNumber() {
		return pfAccountNumber;
	}
	public void setPfAccountNumber(String pfAccountNumber) {
		this.pfAccountNumber = pfAccountNumber;
	}
	public double getPfAmount() {
		return pfAmount;
	}
	public void setPfAmount(double pfAmount) {
		this.pfAmount = pfAmount;
	}


	public double getPfPercentage() {
		return pfPercentage;
	}


	public void setPfPercentage(double pfPercentage) {
		this.pfPercentage = pfPercentage;
	}
	
	
	
}
