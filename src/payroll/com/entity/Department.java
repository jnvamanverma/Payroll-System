package payroll.com.entity;

public class Department {

	private String depId=null;
	private String depName=null;

	

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

}
