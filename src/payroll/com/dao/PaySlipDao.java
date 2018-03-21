package payroll.com.dao;

import payroll.com.entity.PaySlip;

public interface PaySlipDao {

	String addPaySlip(PaySlip paySlip);
	public String editPaySlip(PaySlip paySlip);
	public String deletePaySlip(String Id);
	public String deletePayslipByUserId(String UserId);
	public PaySlip searchPaySlip(String Id);

}
