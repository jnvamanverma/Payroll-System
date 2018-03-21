package payroll.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import payroll.com.dao.EmployeeDao;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	static Connection connection;
	private PreparedStatement preparedStatement=null;
	
	public EmployeeDaoImpl() {

	}
	
	public static void main(String[] args) {
		//Employee employee=new Employee("125", "akhil", "kumar", new java.util.Date(), "male", "xyz@gmail.com","9714771417","part-time", "123456789123","manager","cse","123456789123");

		EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		System.out.println(daoImpl.searchEmployee("128"));
		//System.out.println(daoImpl.editEmployee(employee));
		//System.out.println(daoImpl.addEmployee(employee));
		//Employee emp=daoImpl.searchEmployee("125");
		//System.out.println(emp.getPaySlipId());
		//String num=emp.getAadharnumber();
		//System.out.println(num);
	}

	@Override
	public String addEmployee(Employee employee) {
		String result = "FAIL";
        if(employee==null)
        	return result;
		String sql = "INSERT INTO EMPLOYEE ", p1 = "", p2 = "";

		try {

			if(!(employee.getUserId()==null)){
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "userid";
				p2 = p2 + "'" + employee.getUserId() + "'";
			}
			if (!(employee.getFirstName()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "firstname";
				p2 = p2 + "'" + employee.getFirstName() + "'";
			}
			if (!(employee.getLastName()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "lastname";
				p2 = p2 + "'" + employee.getLastName() + "'";
			}
			
			if (!(employee.getDob()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "dateofbirth";
				p2 = p2 + "?";
			}
			if (!(employee.getEmailId()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "emailid";
				p2 = p2 + "'" + employee.getEmailId() + "'";
			}
			if (!(employee.getPaySlipId()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "paySlipId";
				p2 = p2 + "'" + employee.getPaySlipId() + "'";
			}
			if (!(employee.getGender()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "gender";
				p2 = p2 + "'" + employee.getGender() + "'";
			}
			if (!(employee.getMobileNumber()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "mobileno";
				p2 = p2 + employee.getMobileNumber();
			}
			if (!(employee.getAadharnumber()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "aadharno";
				p2 = p2 + employee.getAadharnumber();
			}
			if (!(employee.getWorkType()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "worktype";
				p2 = p2 + "'" + employee.getWorkType() + "'";
			}
			if (!(employee.getAccountNumber()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "accountno";
				p2 = p2 + employee.getAccountNumber();
			}
			if (!(employee.getDesignation()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "designation";
				p2 = p2 + "'" + employee.getDesignation() + "'";
			}
			if (!(employee.getDepartment()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "department";
				p2 = p2 + "'" + employee.getDepartment() + "'";
			}

			sql = sql + "(" + p1 + ")" + " VALUES(" + p2 + ")";

			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			if (!(employee.getDob()==null))
			preparedStatement.setDate(1,new java.sql.Date(employee.getDob().getTime()));
			System.out.println(sql);
			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				result = "ROW INSERTED";
			}

		} catch (SQLException e) {
			System.out.println("INSERT ERROR...  " + e);
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
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


		return result;
	}

	@Override
	public String editEmployee(Employee employee) {

		String result = "FAIL";
        if(employee==null)
        	return result;
		String sql = "update employee set ", p1 = "";

		try {
			

			if (!(employee.getFirstName()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "firstname='" + employee.getFirstName() + "'";
			}
			if (!(employee.getLastName()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "lastname='" + employee.getLastName() + "'";
			}
			if (!(employee.getDob()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "dateofbirth=" + "?";
			}
			if (!(employee.getEmailId()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "emailid='" + employee.getEmailId() + "'";
			}
			if (!(employee.getPaySlipId()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "paySlipId='" + employee.getPaySlipId() + "'";
			}
			if (!(employee.getGender()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "gender='" + employee.getGender() + "'";
			}
			if (!(employee.getMobileNumber()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "mobileno=" +employee.getMobileNumber();
			}
			if (!(employee.getAadharnumber()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "aadharno=" + employee.getAadharnumber();
			}
			if (!(employee.getWorkType()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "worktype='" + employee.getWorkType() + "'";
			}
			if (!(employee.getAccountNumber()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "accountno=" + employee.getAccountNumber();
			}
			if (!(employee.getDesignation()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "designation='" + employee.getDesignation() + "'";
			}
			if (!(employee.getDepartment()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "department='" + employee.getDepartment() + "'";
			}
			
			
			

			sql = sql + p1 + "where userid='" + employee.getUserId() + "'";
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			if (!(employee.getDob()==null))
			preparedStatement.setDate(1, new java.sql.Date(employee.getDob().getTime()));

			System.out.println(sql);
			
			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				result = "ROW UPDATED";
			}

		} catch (SQLException e) {
			System.out.println("UPDATION ERROR...  " + e);
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
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


		return result;
	}

	@Override
	public String deleteEmployee(String Id) {
		String sql = "DELETE FROM EMPLOYEE WHERE userid = '"+Id+"'";
		String result="FAIL";
		if(Id==null)
			return result;

		try {
			System.out.println(sql);
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			int res=preparedStatement.executeUpdate();
            
			if(res>0)
				result="ROW DELETED SUCCESSFULLY";

		} catch (SQLException e) {
			result="ERROR IN DELETION "+e;
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
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


		return result;
	}

	@Override
	public Employee searchEmployee(String Id) {
		if(Id==null)
			return null;
		String sql = "SELECT * FROM EMPLOYEE where userid='" + Id + "'";
		Employee employee=null;
		try {
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String userid=rs.getString(1);
				String firstname=rs.getString(2);
				String lastname=rs.getString(3);
				Date dateofbirth=rs.getDate(4);
				String emailid=rs.getString(5);
				String gender=rs.getString(6);
				String mobileno=rs.getString(7);
				String aadharno=rs.getString(8);
				String worktype=rs.getString(9);
				String accountno=rs.getString(10);
				String designation=rs.getString(11);
				String department=rs.getString(12);
				String paySlipId=rs.getString(13);
			    employee=new Employee(userid,firstname,lastname,dateofbirth,gender
			    		,emailid,paySlipId,mobileno,worktype,accountno,designation,department,aadharno);
			}

		} catch (SQLException e) {
			System.out.println("ERROR IN LOADING.....  "+e);
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
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


		return employee;
	}

	@Override
	public ArrayList<Employee> searchEmployee(Employee employee) {
		if(employee==null)
			return null;
	ArrayList<Employee>list=new ArrayList<Employee>();
	String sql = "SELECT * FROM EMPLOYEE where ",p1="";
	Employee employee1=null;
	try {
		if (!(employee.getFirstName()==null)) 
		if(!(employee.getFirstName().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "firstname='" + employee.getFirstName() + "'";
		}
		if (!(employee.getLastName()==null)) 
		if(!(employee.getLastName().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "lastname='" + employee.getLastName() + "'";
		}

		if (!(employee.getEmailId()==null)) 
		if(!(employee.getEmailId().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "emailid='" + employee.getEmailId() + "'";
		}
		if (!(employee.getPaySlipId()==null)) 
			if(!(employee.getPaySlipId().isEmpty())){
				if (p1.length() > 0)
					p1 += " and ";
				p1 = p1 + "paySlipId='" + employee.getPaySlipId() + "'";
			}
		if (!(employee.getGender()==null)) 
		if(!(employee.getGender().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "gender='" + employee.getGender() + "'";
		}
		if (!(employee.getMobileNumber()==null)) 
		if(!(employee.getMobileNumber().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "mobileno=" +employee.getMobileNumber();
		}
		if (!(employee.getAadharnumber()==null)) 
		if(!(employee.getAadharnumber().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "aadharno=" + employee.getAadharnumber();
		}
		if (!(employee.getWorkType()==null)) 
		if(!(employee.getWorkType().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "worktype='" + employee.getWorkType() + "'";
		}
		if (!(employee.getAccountNumber()==null)) 
		if(!(employee.getAccountNumber().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "accountno=" + employee.getAccountNumber();
		}
		if (!(employee.getDesignation()==null)) 
		if(!(employee.getDesignation().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "designation='" + employee.getDesignation() + "'";
		}
		if (!(employee.getDepartment()==null)) 
		if(!(employee.getDepartment().isEmpty())){
			if (p1.length() > 0)
				p1 += " and ";
			p1 = p1 + "department='" + employee.getDepartment() + "'";
		}
		
	  if(!(p1.length()>0))
		  return null;
	  
	   sql+=p1;
		connection=DBUtil.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		System.out.println(sql);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			String userid=rs.getString(1);
			String firstname=rs.getString(2);
			String lastname=rs.getString(3);
			Date dateofbirth=rs.getDate(4);
			String emailid=rs.getString(5);
			String gender=rs.getString(6);
			String mobileno=rs.getString(7);
			String aadharno=rs.getString(8);
			String worktype=rs.getString(9);
			String accountno=rs.getString(10);
			String designation=rs.getString(11);
			String department=rs.getString(12);
			String paySlipId=rs.getString(13);
		    employee1=new Employee(userid,firstname,lastname,dateofbirth,gender,emailid,paySlipId,mobileno,worktype,accountno,designation,department,aadharno);
		    list.add(employee1);
		}

	} catch (SQLException e) {
		System.out.println("ERROR IN LOADING.....  "+e);
	}finally {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement = null;
                System.out.println("Statement closed successfully");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
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


	return list;
	}

	@Override
	public ArrayList<Employee> getAll() {
		String sql = "SELECT * FROM EMPLOYEE ";

		Employee employee=null;
		ArrayList<Employee>list=new ArrayList<Employee>();
		try {
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String userid=rs.getString(1);
				String firstname=rs.getString(2);
				String lastname=rs.getString(3);
				Date dateofbirth=rs.getDate(4);
				String emailid=rs.getString(5);
				String gender=rs.getString(6);
				String mobileno=rs.getString(7);
				String aadharno=rs.getString(8);
				String worktype=rs.getString(9);
				String accountno=rs.getString(10);
				String designation=rs.getString(11);
				String department=rs.getString(12);
				String paySlipId=rs.getString(13);
			    employee=new Employee(userid,firstname,lastname,dateofbirth,gender,emailid,paySlipId,mobileno,worktype,accountno,designation,department,aadharno);
			    list.add(employee);
			}

		} catch (SQLException e) {
			System.out.println("ERROR IN LOADING.....  "+e);
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
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


		return list;
	}

}
