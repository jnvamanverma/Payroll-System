package payroll.com.entity;

public class AttendanceSheet {

	String userId=null;
	String dateOfTheDay=null;
	String status=null;
	
	
	public AttendanceSheet(String userId, String dateOfTheDay, String status) {
		super();
		this.userId = userId;
		this.dateOfTheDay = dateOfTheDay;
		this.status = status;
	}
	
	public AttendanceSheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDateOfTheDay() {
		return dateOfTheDay;
	}
	public void setDateOfTheDay(String dateOfTheDay) {
		this.dateOfTheDay = dateOfTheDay;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
