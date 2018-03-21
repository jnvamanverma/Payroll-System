package payroll.com.dao;

import java.util.Date;
import java.util.ArrayList;

import payroll.com.entity.AttendanceSheet;
import payroll.com.extra.service.classes.CountAttendance;

public interface AttendanceSheetDao {
	String addAttendanceSheet(AttendanceSheet attendanceSheet);
	public String editAttendanceSheet(AttendanceSheet attendanceSheet);
	public String deleteAttendanceSheet(String Id);
	public ArrayList<AttendanceSheet> searchAttendanceSheet(String Id);
	public CountAttendance countAttendanceSheet(String Id ,Date date1,Date date2);
	
}
