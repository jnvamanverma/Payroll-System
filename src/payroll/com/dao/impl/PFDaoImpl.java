package payroll.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import payroll.com.dao.PFDao;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.PF;

public class PFDaoImpl implements PFDao{
	
	static Connection connection;
	private PreparedStatement preparedStatement=null;

	public PFDaoImpl() {
	}
public static void main(String[] args) {
	//PF pf=new PF("125",123456,231);
	PFDaoImpl daoImpl=new PFDaoImpl();
	System.out.println(daoImpl.searchPF("125"));
	//System.out.println(daoImpl.addPF(pf));
	  //System.out.println(daoImpl.editPF(pf));
	/*ArrayList<PF> list=daoImpl.searchPF("125");
	for (PF pf2 : list) {
		System.out.println(pf2.getUserId()+pf2.getPfAccountNumber()+pf2.getPfAmount());
	}*/
	//System.out.println(daoImpl.deletePF("125"));
}
	
	@Override
	public String addPF(PF pf) {
		String result = "FAIL";
         if(pf==null)
        	 return result;
		String sql = "INSERT INTO PF ", p1 = "", p2 = "";

		try {
			
			if(!(pf.getUserId()==null)){
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "userid";
				p2 = p2 +"'"+ pf.getUserId()+"'";
			}
			if (!(pf.getPfAccountNumber()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "pfAccountNumber";
				p2 = p2 +""+ pf.getPfAccountNumber()+"";
			}
			if (pf.getPfAmount() > 0) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "pfAmount";
				p2 = p2 + Double.toString(pf.getPfAmount());
			}
			if (pf.getPfPercentage() > 0) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "PfPercentage";
				p2 = p2 + Double.toString(pf.getPfPercentage());
			}
			
			sql = sql + "(" + p1 + ")" + " VALUES(" + p2 + ")";
			connection=DBUtil.getConnection();
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
	public String editPF(PF pf) {
		String result = "FAIL";
        if(pf==null)
        	return result;
		String sql = "update PF set ", p1 = "";

		try {
			
			if (pf.getPfAccountNumber()==null) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "pfAccountNumber=" + pf.getPfAccountNumber();
			}
			if (pf.getPfAmount() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "pfAmount=" + Double.toString(pf.getPfAmount());
			}
			if (pf.getPfPercentage() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "PfPercentage=" + Double.toString(pf.getPfPercentage());
			}
			
			
			sql = sql + p1 + "where userid='" + pf.getUserId() + "'";
			connection=DBUtil.getConnection();
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
	public String deletePF(String Id) {
		String sql = "DELETE FROM PF WHERE userid = '"+Id+"'";
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
	public PF searchPF(String id) {
		String sql = "SELECT * FROM PF where userid='" + id + "'";
		if(id==null)
			return null;

		PF pf=null;
		try {
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String userid=rs.getString(1);
				String pfAccountno=rs.getString(2);
				double pfAmount=rs.getDouble(3);
				double pfPercentage=rs.getDouble(4);
				pf=new PF(userid,pfAccountno,pfAmount,pfPercentage);
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

		return pf;
	}

}
