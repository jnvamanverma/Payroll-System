package payroll.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import payroll.com.dao.AttendanceSheetDao;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.AttendanceSheet;
import payroll.com.entity.Employee;
import payroll.com.entity.PaySlip;
import payroll.com.extra.service.classes.CountAttendance;

public class AttendanceSheetDaoImpl implements AttendanceSheetDao{
	
	
	static Connection connection;
	private PreparedStatement preparedStatement=null;

	public AttendanceSheetDaoImpl() {
		connection=DBUtil.getConnection();
	}

	
	public static void main(String[] args) {
		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		Employee employee=daoImpl.searchEmployee("125");
		PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
		PaySlip paySlip=paySlipDaoImpl.searchPaySlip(employee.getPaySlipId());
		AttendanceSheetDaoImpl attendanceSheetDaoImpl=new AttendanceSheetDaoImpl();
		System.out.println(attendanceSheetDaoImpl.countAttendanceSheet("125",paySlip.getPaidDate(),new Date()));
	}
	@Override
	public String addAttendanceSheet(AttendanceSheet attendanceSheet) {
		String result = "FAIL";

		String sql = " INSERT INTO AttendanceSheet VALUES(?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, attendanceSheet.getUserId());
			preparedStatement.setString(2,attendanceSheet.getDateOfTheDay());
			preparedStatement.setString(3, attendanceSheet.getStatus());

			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				result = "ROW INSERTED";
			}

		} catch (SQLException e) {
			System.out.println("INSERT ERROR..." + e);
		}

		return result;
	}

	@Override
	public String editAttendanceSheet(AttendanceSheet attendanceSheet) {
		String result = "FAIL";

		String sql = "update AttendanceSheet set ", p1 = "";

		try {

			if (!(attendanceSheet.getDateOfTheDay()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "dateoftheday=" + attendanceSheet.getDateOfTheDay();
			}
			if (!(attendanceSheet.getStatus()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "status='" + attendanceSheet.getStatus() + "'";
			}
			
			
			
			

			sql = sql + p1 + "where userid='" + attendanceSheet.getUserId() + "'";
			
			preparedStatement = connection.prepareStatement(sql);

			System.out.println(sql);
			
			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				result = "ROW UPDATED";
			}

		} catch (SQLException e) {
			System.out.println("UPDATION ERROR...  " + e);
		}

		return result;
	}

	@Override
	public String deleteAttendanceSheet(String Id) {
		String sql = "DELETE FROM ATTENDANCESHEET WHERE userid = '"+Id+"'";
		String result="FAIL";
		try {
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			int res=preparedStatement.executeUpdate();
            
			if(res>0)
				result="ROW DELETED SUCCESSFULLY";

		} catch (SQLException e) {
			result="ERROR IN DELETION "+e;
		}
		
		return result;
	}

	@Override
	public ArrayList<AttendanceSheet> searchAttendanceSheet(String Id) {
		String sql = "SELECT * FROM attendancesheet where userid='" + Id + "'";
		ArrayList<AttendanceSheet>list=new ArrayList<AttendanceSheet>();
		AttendanceSheet attendanceSheet=null;
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String userid=rs.getString(1);
				String dateoftheday=rs.getString(2);
				String status=rs.getString(3);
				attendanceSheet=new AttendanceSheet(userid, dateoftheday, status);
				list.add(attendanceSheet);
			}

		} catch (SQLException e) {
			System.out.println("ERROR IN LOADING.....  "+e);
		}
		return list;
	}


	@Override
	public CountAttendance countAttendanceSheet(String Id ,Date date1,Date date2) {
		if(Id==null)
			return null;
		
		String sql="select status,count(*) from ATTENDANCESHEET where userid=? and DATEOFTHEDAY between ? and ? group by status order by status";
		
		CountAttendance countAttendance=null;
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			System.out.println(sql);
			preparedStatement.setString(1,Id);
			preparedStatement.setDate(2,new java.sql.Date(date1.getTime()));
			preparedStatement.setDate(3,new java.sql.Date(date2.getTime()));
			ResultSet rs=preparedStatement.executeQuery();
			int[] arr=new int[3]; 
			int i=0;
			while(rs.next()){
				arr[i]=rs.getInt(2);
				i++;
			}
			countAttendance=new CountAttendance(arr[2],arr[1],arr[0]);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countAttendance;
	}


	public void closeConnection()
	{
		try{
			
		}
		finally {
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                    System.out.println("Connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }
	}
}
