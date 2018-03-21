package payroll.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import payroll.com.dao.DepartmentDao;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.Department;


public class DepartmentDaoImpl implements DepartmentDao {

	static Connection connection;
	private PreparedStatement preparedStatement=null;
	public DepartmentDaoImpl() {

	}

	public static void main(String[] args) {

		//Department department=new Department("256","CSE");
		DepartmentDaoImpl daoImpl=new DepartmentDaoImpl();
		System.out.println(daoImpl.searchDepartment("CSE"));
	    //System.out.println(daoImpl.addDepartment(department));
		//System.out.println(daoImpl.editDepartment(department));
		//System.out.println(daoImpl.deleteDepartment("256"));
		/*ArrayList<Department> list = daoImpl.searchDepartment("256");
		for (Department department1 : list) {
			System.out.println(department1.getDepId()+department1.getDepName());
		}*/
	}

	@Override
	public String addDepartment(Department department) {
		String result = "FAIL";
		if(department==null)
			return result;

		String sql = "INSERT INTO DEPARTMENT ", p1 = "", p2 = "";

		try {
			if (!(department.getDepId()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "DEPT_ID";
				p2 = p2 + "'" + department.getDepId() + "'";
			}
			if (!(department.getDepName()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "DEPT_NAME";
				p2 = p2 + "'" + department.getDepName() + "'";
			}

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
	public String editDepartment(Department department) {
		String result = "FAIL";

		if(department==null)
			return result;
		String sql = "update DEPARTMENT set ", p1 = "";

		try {
			if (!(department.getDepName()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "DEPT_NAME='" + department.getDepName() + "'";

				sql = sql + p1 + "where dept_id='" + department.getDepId() + "'";

				connection = DBUtil.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				System.out.println(sql);
				int res = preparedStatement.executeUpdate();

				if (res > 0) {
					result = "ROW UPDATED";
				}
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
	public String deleteDepartment(String Id) {
		String sql = "DELETE FROM DEPARTMENT WHERE DEPT_ID = '"+Id+"'";
		String result="FAIL";
		if(Id==null)
			return result;
		try {
			System.out.println(sql);
			connection = DBUtil.getConnection();
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
	public Department searchDepartment(String deptName) {
		if(deptName==null)
			return null;
		String sql = "SELECT * FROM DEPARTMENT WHERE DEPT_NAME='" + deptName + "'";

		Department department=null;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String deptID=rs.getString(1);
				String deptName1=rs.getString(2);
				department=new Department(deptID,deptName1);
			}

		} catch (SQLException e) {
			System.out.println("ERROR IN FETCHIING DATA..   "+e);
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


		return department;
	}

}
