package payroll.com.dao;

import payroll.com.entity.PF;

public interface PFDao {
	String addPF(PF pf);
	public String editPF(PF pf);
	public String deletePF(String Id);
	public PF searchPF(String id);
}
