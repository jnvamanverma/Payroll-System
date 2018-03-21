package payroll.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import payroll.com.dao.PaySlipDao;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.PaySlip;

public class PaySlipDaoImpl implements PaySlipDao{
	
	static Connection connection;
	private PreparedStatement preparedStatement=null;

	public PaySlipDaoImpl() {

	}

	
	public static void main(String[] args) {
		PaySlipDaoImpl paySlipDaoImpl=new PaySlipDaoImpl();
		//PaySlip paySlip=new PaySlip("jul12","120",new Date(),1223);
		//System.out.println(paySlipDaoImpl.addPaySlip(paySlip));
		//System.out.println(paySlipDaoImpl.editPaySlip(paySlip));
		//PaySlip paySlip1=paySlipDaoImpl.searchPaySlip("jan11");
		//System.out.println(paySlip1);
		System.out.println(paySlipDaoImpl.deletePayslipByUserId("128"));
	}
	
	@Override
	public String addPaySlip(PaySlip paySlip) {
		String result = "FAIL";
        if(paySlip==null)
        	return result;
		String sql = " INSERT INTO PAYSLIP VALUES(?,?,?,?)";

		try {
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, paySlip.getPaySlipId());
			preparedStatement.setString(2,paySlip.getUserId());
			preparedStatement.setDate(3,new java.sql.Date(paySlip.getPaidDate().getTime()) );
			preparedStatement.setDouble(4,paySlip.getAmount());

			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				result = "ROW INSERTED";
			}

		} catch (SQLException e) {
			System.out.println("INSERT ERROR..." + e);
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
	public String editPaySlip(PaySlip paySlip) {
		String result = "FAIL";
        if(paySlip==null)
        	return result;
		String sql = " UPDATE PAYSLIP set userid=?,paiddate=?,amount=? where payslipid=?";

		try {
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1,paySlip.getUserId());
			preparedStatement.setDate(2,new java.sql.Date(paySlip.getPaidDate().getTime()) );
			preparedStatement.setDouble(3,paySlip.getAmount());
			preparedStatement.setString(4, paySlip.getPaySlipId());

			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				result = "ROW UPDATED";
			}

		} catch (SQLException e) {
			System.out.println("update ERROR..." + e);
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
	public String deletePaySlip(String Id) {
		String sql = "DELETE FROM PAYSLIP WHERE paySlipId = '"+Id+"'";
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
	public PaySlip searchPaySlip(String Id) {
		if(Id==null)
			return null;
		String sql = "SELECT * FROM PAYSLIP where paySlipId='" + Id + "'";

		PaySlip paySlip=null;
		try {
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String paySlipId= rs.getString(1);
				String userId=rs.getString(2);
				Date paidDate=rs.getDate(3);
				Double amount=rs.getDouble(4);
				paySlip=new PaySlip(paySlipId,userId,paidDate,amount);
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

		return paySlip;
	}


	@Override
	public String deletePayslipByUserId(String UserId) {
		String sql = "DELETE FROM PAYSLIP WHERE userId = '"+UserId+"'";
		String result="FAIL";
		if(UserId==null)
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
	
	

}
