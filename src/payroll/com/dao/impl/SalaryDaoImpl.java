package payroll.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import payroll.com.dao.SalaryDao;
import payroll.com.db.util.DBUtil;

import payroll.com.entity.Salary;

public class SalaryDaoImpl implements SalaryDao {

	static Connection connection;
	private PreparedStatement preparedStatement=null;

	public SalaryDaoImpl() {
	}

	public static void main(String[] args) {
		//Salary salary = new Salary("125", 19000, 150, 120, 17000);
		SalaryDaoImpl salaryDaoImpl = new SalaryDaoImpl();
		//System.out.println(salaryDaoImpl.addSalary(salary));
		// System.out.println(addressDaoImpl.deleteAddress("125"));
		// System.out.println(salaryDaoImpl.editSalary(salary));
		//ArrayList<Salary> list = salaryDaoImpl.searchSalary("125");
		System.out.println(salaryDaoImpl.searchSalary("128"));
		//for (Salary salary2 : list) {"
			//System.out.println(
				//	salary2.getUserId() + Double.toString(salary2.getNetSalary()) + Double.toString(salary2.getBonus())
				//			+ Double.toString(salary2.getAllowance()) + Double.toString(salary2.getBasicSalary()));
		//}
	}

	@Override
	public String addSalary(Salary salary) {
		String result = "FAIL";
		if(salary==null)
			return result;

		String sql = "INSERT INTO SALARY", p1 = "", p2 = "";

		if (!(salary.getUserId() == null)) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "userid";
			p2 = p2 + "'" + salary.getUserId() + "'";
		}
		if (salary.getNetSalary() > 0) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "net_salary";
			p2 = p2 + Double.toString(salary.getNetSalary());
		}
		if (salary.getBonus() > 0) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "bonus";
			p2 = p2 + Double.toString(salary.getBonus());
		}
		if (salary.getAllowance() > 0) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "allowance";
			p2 = p2 + Double.toString(salary.getAllowance());
		}
		if (salary.getBasicSalary() > 0) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "basic_salary";
			p2 = p2 + Double.toString(salary.getBasicSalary());
		}

		try {
			sql = sql + "(" + p1 + ")" + " VALUES(" + p2 + ")";

			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
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
	public String editSalary(Salary salary) {
		String result = "FAIL";
		if(salary==null)
			return result;

		String sql = "update salary set ", p1 = "";

		try {

			if (!(salary.getUserId() == null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "userid='" + salary.getUserId() + "'";
			}
			if (salary.getNetSalary() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "net_salary=" + Double.toString(salary.getNetSalary());
			}
			if (salary.getAllowance() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "allowance=" + Double.toString(salary.getAllowance());
			}
			if (salary.getBonus() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "bonus=" + Double.toString(salary.getBonus());
			}
			if (salary.getBasicSalary() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "basic_salary=" + Double.toString(salary.getBasicSalary());
			}

			sql = sql + p1 + "where userid='" + salary.getUserId() + "'";

			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
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
	public String deleteSalary(String Id) {
		String sql = "DELETE FROM SALARY WHERE USERID =?";
		String result = "FAIL";
		if(Id==null)
			return result;

		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, Id);
			System.out.println(sql);
			int res = preparedStatement.executeUpdate();

			if (res > 0)
				result = "ROW DELETED SUCCESSFULLY";

		} catch (SQLException e) {
			result = "ERROR IN DELETION " + e;
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
	public Salary searchSalary(String id) {
		String sql = "SELECT * FROM SALARY where userid='" + id + "'";

		if(id==null)
			return null;
		Salary salary=null;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String id1 = rs.getString(1);
				double netsalary = rs.getDouble(2);
				double bonus = rs.getDouble(3);
				double allowance = rs.getDouble(4);
				double basicsalary = rs.getDouble(5);
				salary = new Salary(id1, netsalary, bonus, allowance, basicsalary);
			}

		} catch (SQLException e) {
			System.out.println("ERROR IN FETCHING.....  "+e);
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

		return salary;
	}

}
