package payroll.com.extra.service.classes;

public class CountAttendance {
	

	int workingDays;
	int el;
	int cl;
	public CountAttendance(int workingDays, int el, int cl) {
		super();
		this.workingDays = workingDays;
		this.el = el;
		this.cl = cl;
	}
	public CountAttendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}
	public int getEl() {
		return el;
	}
	public void setEl(int el) {
		this.el = el;
	}
	public int getCl() {
		return cl;
	}
	public void setCl(int cl) {
		this.cl = cl;
	}
	
	

}
