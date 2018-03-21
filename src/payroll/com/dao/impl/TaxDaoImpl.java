package payroll.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import payroll.com.dao.TaxDao;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.Tax;

public class TaxDaoImpl implements TaxDao {
	
	static Connection connection;
	private PreparedStatement preparedStatement=null;

	public TaxDaoImpl() {
	}
	
	
    public static void main(String[] args) {
     // Tax tax=new Tax("125",200,1254,120,12000,600,11000);
      TaxDaoImpl daoImpl=new TaxDaoImpl();
     // System.out.println(daoImpl.addTax(tax));
     // System.out.println(daoImpl.editTax(tax));
       Tax tax2=daoImpl.searchTax("125");
		System.out.println(tax2.getUserId()+Double.toString(tax2.getIncomeTax())+Double.toString(tax2.getServiceTax()));
	
     // System.out.println(daoImpl.deleteTax("125"));
    }


	@Override
	public String addTax(Tax tax) {
		String result = "FAIL";
		if(tax==null)
			return result;

		String sql = "INSERT INTO TAX ", p1 = "", p2 = "";
		
		try {

			if(!(tax.getUserId()==null)){
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1+="userid";
				p2=p2+"'"+tax.getUserId()+"'";
			}
			if (tax.getIncomeTax() > 0) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "income_tax";
				p2 = p2 + Double.toString(tax.getIncomeTax());
			}
			if (tax.getServiceTax() > 0) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "service_tax";
				p2 = p2 + Double.toString(tax.getServiceTax());
			}
			if (tax.getPfDeduction() > 0) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "pfDeduction";
				p2 = p2 + Double.toString(tax.getPfDeduction());
			}
			if (tax.getTotalEarning() > 0) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "totalEarning";
				p2 = p2 + Double.toString(tax.getTotalEarning());
			}
			if (tax.getTotalDeduction() > 0) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "totalDeduction";
				p2 = p2 + Double.toString(tax.getTotalDeduction());
			}
			if (tax.getNetSalary() > 0) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "netSalary";
				p2 = p2 + Double.toString(tax.getServiceTax());
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
	public String editTax(Tax tax) {
		String result = "FAIL";
		if(tax==null)
			return result;

		String sql = "update tax set ", p1 = "";
		
		try {
			
			if (tax.getIncomeTax() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "income_tax=" + Double.toString(tax.getIncomeTax());
			}
			if (tax.getServiceTax() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "service_tax=" + Double.toString(tax.getServiceTax());
			}
			if (tax.getPfDeduction() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "pfDeduction=" + Double.toString(tax.getPfDeduction());
			}
			if (tax.getTotalEarning() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "totalEarning=" + Double.toString(tax.getTotalEarning());
			}
			if (tax.getTotalDeduction() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "totalDeduction=" + Double.toString(tax.getTotalDeduction());
			}
			if (tax.getNetSalary() > 0) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "netSalary=" + Double.toString(tax.getNetSalary());
			}
			
			sql = sql + p1 + "where userid='" + tax.getUserId() + "'";

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
	public String deleteTax(String Id) {
		String sql = "DELETE FROM TAX WHERE userid = '"+Id+"'";
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
	public Tax searchTax(String id) {
		if(id==null)
			return null;
		String sql = "SELECT * FROM TAX where userid='" + id + "'";

		Tax tax=null;
		try {
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String userid=rs.getString(1);
				double income_tax=rs.getDouble(2);
				double service_tax=rs.getDouble(3);
			    double pfDeduction=rs.getDouble(4);
			    double totalEarning=rs.getDouble(5);
			    double totalDeduction=rs.getDouble(6);
			    double netSalary=rs.getDouble(7);
				tax=new Tax(userid,income_tax,service_tax,pfDeduction,totalEarning,totalDeduction,netSalary); 
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

		return tax;
	}

}
