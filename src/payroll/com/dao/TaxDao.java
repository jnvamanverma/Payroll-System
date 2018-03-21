package payroll.com.dao;

import payroll.com.entity.Tax;

public interface TaxDao {
	String addTax(Tax tax);
	public String editTax(Tax tax);
	public String deleteTax(String Id);
	public Tax searchTax(String id);
}
