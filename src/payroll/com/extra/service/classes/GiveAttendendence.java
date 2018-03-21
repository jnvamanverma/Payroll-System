package payroll.com.extra.service.classes;

import payroll.com.dao.impl.AttendanceSheetDaoImpl;
import payroll.com.entity.AttendanceSheet;

public class GiveAttendendence {

	
	public static void main(String[] args) {
	//	GiveAttendendence attendendence=new GiveAttendendence();
		//attendendence.insertAttendence("125");
		//AttendanceSheetDaoImpl attendanceSheetDaoImpl=new AttendanceSheetDaoImpl();
		//attendanceSheetDaoImpl.deleteAttendanceSheet("Ri52");
	}
	
	AttendanceSheetDaoImpl attendanceSheetDaoImpl=new AttendanceSheetDaoImpl();
	public void insertAttendence(String userId){
		String dateOfTheDay="-jul-17";
		String status="p",date=null;
		
		AttendanceSheet attendanceSheet=null;
		for(int i=2;i<30;i++)
		{
			date=Integer.toString(i)+dateOfTheDay;
			attendanceSheet=new AttendanceSheet(userId,date,status);
			 System.out.println(attendanceSheetDaoImpl.addAttendanceSheet(attendanceSheet));
		}
		
		attendanceSheetDaoImpl.closeConnection();
	  
		
		
	}
}
