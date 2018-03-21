package payroll.com.entity;

import java.util.Date;

public class PaySlip {

	String paySlipId=null;
	String userId=null;
	Date paidDate=null;
	double amount=0;
	
	
	
	public PaySlip(String paySlipId, String userId, Date paidDate, double amount) {
		super();
		this.paySlipId = paySlipId;
		this.userId = userId;
		this.paidDate = paidDate;
		this.amount = amount;
	}
	public PaySlip() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPaySlipId() {
		return paySlipId;
	}
	public void setPaySlipId(String paySlipId) {
		this.paySlipId = paySlipId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
